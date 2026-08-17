package com.samarpit.LibraryManagementSystemAPI.dto;

public class AuthenticationRequest {
    private String email;
    private String password;

    // Add standard Getters and Setters here
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}