package com.jaqstack.models;

/**
 * API model for the authentication token.
 *
 * @author Suren Konathala
 */
public class AuthenticationToken {
    private String token;

    public AuthenticationToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
