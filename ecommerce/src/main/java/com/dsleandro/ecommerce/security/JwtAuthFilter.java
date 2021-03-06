package com.dsleandro.ecommerce.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.dsleandro.ecommerce.security.SecurityConstants.SECRET;
import static com.dsleandro.ecommerce.security.SecurityConstants.TOKEN_PREFIX;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            com.dsleandro.ecommerce.models.User creds = new ObjectMapper().readValue(req.getInputStream(),
                    com.dsleandro.ecommerce.models.User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
                    creds.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        String token = JWT.create().withSubject(((User) auth.getPrincipal()).getUsername())
                .sign(HMAC512(SECRET.getBytes()));

         // send token
         res.setContentType("application/json");
         res.getWriter().write("{\"accessToken\" : \"" + TOKEN_PREFIX + token + "\"}");

    }
}