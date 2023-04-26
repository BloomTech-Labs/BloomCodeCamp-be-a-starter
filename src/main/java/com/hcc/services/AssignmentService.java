package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository repository;

    public Optional<List<Assignment>> loadAssignmentsByUser(User user) {
        Long userId = user.getId();
        return repository.findByUserId(userId);
    }

    public Optional<Assignment> loadAssignmentById(Long id) {
        return repository.findById(id);
    }

    public void save(Assignment assignment) {
        repository.save(assignment);
    }

    public void delete(Assignment assignment) {
        repository.delete(assignment);
    }
}
