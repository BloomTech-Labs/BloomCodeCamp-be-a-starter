package com.hcc;

import com.hcc.controllers.loginController;
import com.hcc.dto.AuthCredentialRequest;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureDataJpa
public class loginTests {
    @Mock
    User user;
    @Mock
    loginController controller;

    @BeforeEach
    void setUp() {
        Authority authority = new Authority("student");
        List<Authority> list = new ArrayList<>();
        list.add(authority);
        user = new User(new Date(3-6-2023), "bob", "green", list);

    }

    @Test
    public void givenValidUsername_thenLogin() {
        AuthCredentialRequest request = new AuthCredentialRequest();
        request.setUsername(user.getUsername());
        request.setPassword(user.getPassword());
        assertEquals("bob", user.getUsername());
        Mockito.when(controller.login(request));

    }

    @Test
    public void givenInvalidUsername_thenDontLogin() {
        AuthCredentialRequest request = new AuthCredentialRequest();
        request.setUsername("steve");
        request.setPassword(user.getPassword());
        Mockito.when(controller.login(request)).thenThrow(RuntimeException.class);
    }
}
