package com.hcc;

import com.hcc.entities.Assignment;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Assignment.class)
public class AssignmentEntitiesTests {

    @Mock
    private Assignment assignment;
    private String status;
    private int number;
    private String githubUrl;
    private String branch;
    private String reviewVideoUrl;
    private User user;
    private User reviewer;

    @BeforeEach
    public void setUp() {
        status = "submitted";
        number = 123789;
        githubUrl = "https://gitHub.com/tommytrain23";
        branch = "main";
        reviewVideoUrl = "https://Loom.com/tommy";
        user = new User();
        reviewer = new User();
        assignment = new Assignment(status, number, githubUrl, branch, reviewVideoUrl, user, reviewer);
    }

    @Test
    void getStatus_returnsNonNullStatus(){
        String status1 = "submitted";
        assertNotNull(assignment.getStatus());
        assertEquals(status1, assignment.getStatus());
    }
    @Test
    void setStatus_returnsUpdatedStatus() {
        String passed = "passed";
        assignment.setStatus(passed);
        assertEquals(passed, assignment.getStatus());
    }
    @Test
    void getNumber_ReturnsNonNullAssignmentNumber() {
        int expectedNumber = 123789;
        assertNotNull(assignment.getNumber());
        assertEquals(expectedNumber, assignment.getNumber());
    }
    @Test
    void getGithubUrl_ReturnsNonNullUrl() {
        String expectedUrl = "https://gitHub.com/tommytrain23";
        assertNotNull(assignment.getGithubUrl());
        assertEquals(expectedUrl, assignment.getGithubUrl());
    }
    @Test
    void getBranch_returnsNonNullBranch() {
        String expectedBranch = "main";
        assertNotNull(assignment.getBranch());
        assertEquals(expectedBranch, assignment.getBranch());
    }
    @Test
    void setBranch_UpdatesBranch() {
        String updatedBranch = "working";
        assignment.setBranch(updatedBranch);
        assertEquals(updatedBranch, assignment.getBranch());
    }
    @Test
    void getReviewUrl_ReturnsNonNullUrl() {
        String expectedUrl = "https://Loom.com/tommy";
        assertNotNull(assignment.getReviewVideoUrl());
        assertEquals(expectedUrl, assignment.getReviewVideoUrl());
    }

}
