package com.hcc.repositories;

import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(String id);
    Optional<User> saveUser(User user);
    Optional<User> createUser(User user);
    void deleteUser(User user);
}
