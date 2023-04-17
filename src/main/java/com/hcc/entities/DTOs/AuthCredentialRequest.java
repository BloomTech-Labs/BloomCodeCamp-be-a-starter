package com.hcc.entities.DTOs;

public class AuthCredentialRequest{
    private String username;
    private String password;

    public AuthCredentialRequest(String username , String password) {
        this.username = username;
        this.password = password;
    }

    protected AuthCredentialRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String password;

        Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        AuthCredentialRequest build() {
            return new AuthCredentialRequest(this);
        }
    }
}
