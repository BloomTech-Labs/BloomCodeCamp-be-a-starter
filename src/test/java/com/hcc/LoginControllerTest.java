package com.hcc;

import com.hcc.controllers.LoginController;
import com.hcc.entities.DTOs.AuthCredentialRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
//    private AuthCredentialRequest request;
//
//    @BeforeEach
//    protected void setup() {
//        request.setUsername("jhon");
//        request.setPassword("password");
//    }

    private LoginController controller = new LoginController();

    @Test
    public void check() throws Exception {
        AuthCredentialRequest request = AuthCredentialRequest.builder()
                .withUsername("jhon")
                .withPassword("password")
                .build();

        ResponseEntity<?> response = controller.login(request);

        System.out.println(response.toString());
    }
}
