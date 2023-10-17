package com.hcc;

import com.hcc.controllers.getAssignmentController;
import com.hcc.controllers.updateAssignmentController;
import com.hcc.dto.updateAssignmentRequest;
import com.hcc.entities.Assignment;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import com.hcc.services.AssignmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureDataJpa
public class updateAssignmentTests {
    @Mock
    updateAssignmentController controller;
    @Mock
    AssignmentService service;
    @Mock
    User student;
    @Mock
    User student2;
    @Mock
    User teacher;
    @Mock
    Assignment assignment;
    @Mock
    Assignment assignment3;
    @Mock
    updateAssignmentRequest request;
    List<Assignment> list1 = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Authority authorityStudent = new Authority("student");
        Authority authorityAdmin = new Authority("admin");
        List<Authority> authorityListStudent = new ArrayList<>();
        List<Authority> authorityListAdmin = new ArrayList<>();
        authorityListStudent.add(authorityStudent);
        authorityListAdmin.add(authorityStudent);
        authorityListAdmin.add(authorityAdmin);
        student = new User(new Date(8-24-2022), "teddy", "gold", authorityListStudent);
        teacher = new User(new Date(8-24-2022), "eric", "password", authorityListAdmin);
        student2 = new User(new Date(8-24-2022), "scott", "bobe", authorityListStudent);
        student.setId(12345L);
        assignment = new Assignment("assigned", 2345, "github.url", "main", "review.url", student, teacher);
        assignment3 = new Assignment("in review", 2355, "github.url3", "main3", "review.url", student, teacher);

        request = new updateAssignmentRequest("in review", 2678, "github.url/new", "main", "video.url/new", student, teacher);
        list1.add(assignment);
        list1.add(assignment3);

    }

    @Test
    void callingSave_updatesAssignment() {
        service.updateAssignment(assignment,request);
        controller.save(assignment,request);
        System.out.println(assignment.getStatus());
        assertEquals(request.getCodeReviewer(), assignment.getCodeReviewer());
        assertEquals(request.getBranch(), assignment.getBranch());
        assertEquals(request.getUser(), assignment.getUser());
        }
}
