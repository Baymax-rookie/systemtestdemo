package org.systemtest.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author 12589
 */
public class JwtUtil {
    private static final long EXPIRE_Time=60*60*1000;

    public static boolean verify(String token,String username,String secret) throws UnsupportedEncodingException {
        Algorithm algorithm= Algorithm.HMAC256(secret);
        JWTVerifier verifier= JWT.require(algorithm)
                .withClaim("username",username)
                .build();
        DecodedJWT jwt=verifier.verify(token);
        return true;
    }

    public static String getUsername(String token){
        DecodedJWT jwt=JWT.decode(token);
        return jwt.getClaim("username").asString();
    }

    public static String sign(String username,String secret) throws UnsupportedEncodingException {
        Date date=new Date(System.currentTimeMillis()+EXPIRE_Time);
        Algorithm algorithm=Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("username",username)
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
