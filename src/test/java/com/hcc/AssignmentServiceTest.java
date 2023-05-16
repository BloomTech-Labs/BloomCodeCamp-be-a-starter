package com.hcc;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.services.AssignmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AssignmentServiceTest {

    @Autowired
    AssignmentService service;

    @Test
    void loadListOfAssignments_usingValidUser() {
        // GIVEN
        User user = User.builder()
                .withUsername("jhon")
                .withPassword("password")
                .build();
        // WHEN
        Optional<List<Assignment>> assignments = service.loadAssignmentsByUser(user);

        // THEN
        assertAll(
                () -> assertNotNull(assignments, "Expected assignments to not be null"),
                () -> assertFalse(assignments.isEmpty(), "Expected assignments not to be empty"),
                () -> assertEquals(user.getUsername(),
                        assignments.get().get(0).getUser().getUsername(),
                        "Expected assignment to match with given User")
        );
    }
    @Test
    void loadListOfAssignments_usingValidAssignmentId() {
        // GIVEN
        Long id = 1L;

        // WHEN
        Optional<Assignment> assignments = service.loadAssignmentById(id);

        // THEN
        assertAll(
                () -> assertNotNull(assignments, "Expected assignments to not be null"),
                () -> assertFalse(assignments.isEmpty(), "Expected assignments not to be empty")
        );
    }
    @Test
    void saveNewAssignment_givenValidAssignment() {
        // GIVEN
        User user  = User.builder()
                .withUsername("jhon")
                .withPassword("password")
                .build();

        Assignment assignment = Assignment.builder()
                .withNumber(1)
                .withUser(user)
                .build();

        // WHEN/THEN
        verify(service).save(assignment);

    }
    @Test
    void deleteAssignment_givenValidAssignment() {
        // GIVEN
        User user  = User.builder()
                .withUsername("jhon")
                .withPassword("password")
                .build();

        Assignment assignment = Assignment.builder()
                .withNumber(1)
                .withUser(user)
                .build();

        // WHEN/THEN
        verify(service).delete(assignment);
    }
}
