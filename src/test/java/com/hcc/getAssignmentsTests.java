package com.hcc;

import com.hcc.controllers.getAssignmentController;
import com.hcc.entities.Assignment;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureDataJpa
public class getAssignmentsTests {
    @Mock
    getAssignmentController controller;
    @Mock
    User student;
    @Mock
    User student2;
    @Mock
    User teacher;

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
        Assignment assignment = new Assignment("assigned", 2345, "github.url", "main", "review.url", student, teacher);
        Assignment assignment1 = new Assignment("assigned", 2245, "github.url1", "main1", "review.url", student2, teacher);
        Assignment assignment2 = new Assignment("submitted", 2335, "github.url2", "main2", "review.url", student2, teacher);
        Assignment assignment3 = new Assignment("in review", 2355, "github.url3", "main3", "review.url", student, teacher);

        list1.add(assignment);
        list1.add(assignment3);
    }

    @Test
    void findByUsername_ValidUser_returnsAssignmentsForUser() {
        Mockito.when(controller.getAssignmentsByUser(student)).thenReturn(list1);
    }

    @Test
    void findById_ValidID_returnsAssignmentForID() {
        Mockito.when(controller.getAssignmentsByID(student.getId())).thenReturn(list1.get(0));
    }
}
