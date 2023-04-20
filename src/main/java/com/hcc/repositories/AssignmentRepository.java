package com.hcc.repositories;

import com.hcc.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<List<Assignment>> findById(String id);
    Optional<List<Assignment>> findByUserId(String id);
    Optional<Assignment> saveAssignment(Assignment assignment);
    Optional<Assignment> createAssignment(Assignment assignment);
    void deleteAssignment(Assignment assignment);
}