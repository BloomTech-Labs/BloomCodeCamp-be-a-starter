package com.hcc;

import com.hcc.services.UserDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailServiceTest {

    @Autowired
    UserDetailServiceImpl service;

    @Test
    void giveValidUsername_returnsValidUserDetails() {
        // GIVEN
        String validUsername = "jhon";
        Long id = 1L;

        // WHEN
        UserDetails userDetails = service.loadUserByUsername(validUsername);

        // THEN
        assertEquals(userDetails.getUsername(), validUsername,
                        String.format("Expected a valid username of: %s, but got %s",
                                validUsername, userDetails.getUsername()));
    }

    @Test
    void giveInvalidUsername_throwsUserNotFoundException() {
        // GIVEN
        String invalidUsername = "invalidUsername";

        // WHEN/THEN
        assertThrows(UsernameNotFoundException.class,
                () -> service.loadUserByUsername(invalidUsername),
                "Expected method to throw an exception if a user cannot be found.");
    }
}
