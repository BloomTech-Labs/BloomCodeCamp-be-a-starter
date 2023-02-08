package com.hcc.dtos;

public class AuthCredentialRequest {

    private String username;

    private String password;

    public AuthCredentialRequest() {
    }

    public AuthCredentialRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
