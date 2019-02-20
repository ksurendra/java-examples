package com.jaqstack.helpers;

/**
 * Thrown if errors occur during the authentication process.
 *
 * @author Suren Konathala
 */
public class AuthenticationException extends RuntimeException  {
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
