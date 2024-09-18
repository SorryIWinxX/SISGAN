package com.uis.sisgan.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class SecurityConstants {

    public static final long JWT_EXPRIRATION = 700000000;

    public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);



}
