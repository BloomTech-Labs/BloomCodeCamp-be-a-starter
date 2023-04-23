package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.DTOs.AssignmentResponseDto;
import com.hcc.entities.User;
import com.hcc.enums.AuthorityEnum;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @GetMapping(value = "/api/assignments", produces = {"application/json"})
    ResponseEntity<?> getAssignmentsByUser(@AuthenticationPrincipal User user) throws Exception {

            if (user.getAuthorities().contains(AuthorityEnum.LEARNER.name())) {
                throw new Exception("You do not have the authority for this action.");
            }

            List<AssignmentResponseDto> assignments = assignmentService
                    .loadAssignmentsByUser(user).orElseThrow(FileNotFoundException::new)
                    .stream()
                    .map(assignment -> {
                        return new AssignmentResponseDto.Builder()
                                .withStatus(assignment.getStatus())
                                .withNumber(assignment.getNumber())
                                .withGithubUrl(assignment.getGithubUrl())
                                .withBranch(assignment.getBranch())
                                .withReviewVideoUrl(assignment.getReviewVideoUrl())
                                .build();
                    })
                    .collect(Collectors.toList());

            return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @GetMapping(value = "/api/assignments/{id}", produces = {"application/json"})
    ResponseEntity<?> GetAssignmentById(@PathVariable String id) throws FileNotFoundException {
        Assignment assignment = assignmentService.loadAssignmentById(Long.valueOf(id))
                .orElseThrow(FileNotFoundException::new);

        return new ResponseEntity<>(new AssignmentResponseDto.Builder()
                .withStatus(assignment.getStatus())
                .withNumber(assignment.getNumber())
                .withGithubUrl(assignment.getGithubUrl())
                .withBranch(assignment.getBranch())
                .withReviewVideoUrl(assignment.getReviewVideoUrl())
                .build(), HttpStatus.OK);
    }

    @PutMapping(value = "/api/assignments/{id}", produces = {"application/json"})
    ResponseEntity<?> PutAssignmentById(@PathVariable String id) {
        assignmentService.addNewAssignmentById(Long.valueOf(id));
        return new ResponseEntity<>(AssignmentResponseDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping(value = "/api/assignments", produces = {"application/json"})
    ResponseEntity<?> postAssignment(@Validated @RequestBody Assignment request) {
        assignmentService.updateAssignment(request);

        return new ResponseEntity<>(new AssignmentResponseDto.Builder()
                .withStatus(request.getStatus())
                .withNumber(request.getNumber())
                .withGithubUrl(request.getGithubUrl())
                .withBranch(request.getBranch())
                .withReviewVideoUrl(request.getReviewVideoUrl())
                .build(), HttpStatus.OK);
    }

}
