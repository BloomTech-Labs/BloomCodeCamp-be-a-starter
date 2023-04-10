package com.hcc.entities.DTOs;

public record AuthCredentialRequest (
        String username,
        String password
){
}
