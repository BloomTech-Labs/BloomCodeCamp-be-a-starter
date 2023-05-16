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

    /**
     * Receives a GET request from the frontend, using the request to get a list of
     * assignments from the DB
     * @param user A USER object
     * @return A new ResponseEntity object containing a list of assignments and status
     * @throws Exception will throw an exception if the authority of the user is not a learner.
     */
    @GetMapping(value = "/api/assignments",consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<?> getAssignmentsByUser(@AuthenticationPrincipal User user) throws Exception {

            if (user.getAuthorities().contains(AuthorityEnum.LEARNER_ROLE.name())) {
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

    /**
     *  Gets an assignment object using a given ID
     * @param id the assignments' id to search for
     * @return A new ResponseEntity containing ARD and status
     * @throws FileNotFoundException if the assignment is not found
     */
    @GetMapping(value = "/api/assignments/{id}", produces = {"application/json"})
    ResponseEntity<?> GetAssignmentById(@PathVariable Long id) throws FileNotFoundException {
        Assignment assignment = assignmentService.loadAssignmentById(id)
                .orElseThrow(FileNotFoundException::new);

        return new ResponseEntity<>(new AssignmentResponseDto.Builder()
                .withStatus(assignment.getStatus())
                .withNumber(assignment.getNumber())
                .withGithubUrl(assignment.getGithubUrl())
                .withBranch(assignment.getBranch())
                .withReviewVideoUrl(assignment.getReviewVideoUrl())
                .build(), HttpStatus.OK);
    }

    /**
     *  Puts an updated Assignment in the DB using the modified assignment and the
     *  originals ID.
     * @param id the unique identifier for the original assignment to be replaced.
     * @param request the updated assignment to replace the original.
     * @return the updated assignment in an ARD and a status.
     * @throws FileNotFoundException
     */
    @PutMapping(value = "/api/assignments/{id}", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<?> putAssignmentById(@PathVariable Long id, @RequestBody Assignment request) throws FileNotFoundException{
        Assignment assignment = assignmentService.loadAssignmentById(id)
                .orElseThrow(FileNotFoundException::new);
        assignmentService.delete(assignment);

        request.setId(id);
        assignmentService.save(request);

        return new ResponseEntity<>(new AssignmentResponseDto.Builder()
                .withStatus(request.getStatus())
                .withNumber(request.getNumber())
                .withGithubUrl(request.getGithubUrl())
                .withBranch(request.getBranch())
                .withReviewVideoUrl(request.getReviewVideoUrl())
                .build(), HttpStatus.OK);
    }

    /**
     * Puts a brand-new assignment in the DB
     * @param request The new Assignment to put inside the DB
     * @return an ARD of the new assignment and a status in a new responseEntity.
     */
    @PostMapping(value = "/api/assignments", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<?> postAssignment(@Validated @RequestBody Assignment request) {
        assignmentService.save(request);

        return new ResponseEntity<>(new AssignmentResponseDto.Builder()
                .withStatus(request.getStatus())
                .withNumber(request.getNumber())
                .withGithubUrl(request.getGithubUrl())
                .withBranch(request.getBranch())
                .withReviewVideoUrl(request.getReviewVideoUrl())
                .build(), HttpStatus.OK);
    }

}
