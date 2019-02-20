package com.jaqstack.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.io.Serializable;
import java.security.Key;
import javax.enterprise.context.RequestScoped;
/**
 * Service which provides operations for authentication tokens.
 *
 * @author Suren Konathala
 */
@RequestScoped
public class AuthenticationTokenService implements Serializable {

    public String issueToken(String username) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = Jwts.builder().setSubject(username).signWith(key).compact();

        return jws;
    }

}
