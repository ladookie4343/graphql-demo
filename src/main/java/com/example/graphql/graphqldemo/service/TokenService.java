package com.example.graphql.graphqldemo.service;

import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.User;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TokenService {

    private static String key = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=";

    public static User loggedInUser(DataFetchingEnvironment env) {
        GraphQLContext context = env.getContext();
        Optional<HttpServletRequest> httpServletRequest = context.getHttpServletRequest();
        String jwtString = httpServletRequest
                .map(req -> req.getHeader("Authorization"))
                .filter(header -> !header.isEmpty())
                .map(header -> header.replace("Bearer ", ""))
                .map(String::toString)
                .orElse(null);

        DefaultJws jwt = (DefaultJws) Jwts.parser().setSigningKey(key.getBytes()).parse(jwtString);
        DefaultClaims claims = (DefaultClaims) jwt.getBody();
        String subject = claims.getSubject();

        List<User> users = DB.getUsers().stream()
                .filter(user -> user.getId().equals(subject))
                .collect(Collectors.toList());

        return users.size() > 0 ? users.get(0) : null;
    }

    public static String createJWT(String userId) {
        return Jwts.builder()
                .setIssuer("me")
                .setSubject(userId)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();
    }
}
