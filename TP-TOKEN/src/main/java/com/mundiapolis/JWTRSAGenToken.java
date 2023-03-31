package com.mundiapolis;

import com.mundiapolis.CryptoUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.security.PrivateKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTRSAGenToken {
    public static String createJwtToken(PrivateKey privateKey){
        String token =null;
        Instant now=Instant.now();
        Map<String,String> claims=new HashMap<>();
        claims.put("Name : ","oussama");
        claims.put("Age : ","21 ans");
        claims.put("email : ","o.saadi@mundiapolis.ma");

        JwtBuilder jwtBuilder= Jwts.builder().setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(2, ChronoUnit.DAYS)))
                .setClaims(claims)
                .signWith(privateKey)
                ;
        token=jwtBuilder.compact();
        return token;
    }
    public static void main(String[] args) throws Exception {

        PrivateKey privateKey = CryptoUtils.getPrivateKeyFromKeyStore("oussama.jks","123321","oussama");
        String token=createJwtToken(privateKey);
        System.out.println(token);
    }
}
