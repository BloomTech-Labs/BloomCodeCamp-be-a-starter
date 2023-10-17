package com.hcc.repositories;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

        List<Assignment> findByUserId(User userId);

        Assignment findByAssignmentId(Long id);


        Assignment save(Assignment id);



        // Other methods for CRUD operations or custom queries
    }

