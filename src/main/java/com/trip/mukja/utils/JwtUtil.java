package com.trip.mukja.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    public static String getMemberId(String token,String secretKey){
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().get("memberId",String.class);
    }
    public static boolean isExpired(String token, String secretKey){
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
    public static String createJwt(String userId, String secretKey, long expireTimesMs){
        // 일종의 map
        Claims claims = Jwts.claims();
        claims.put("memberId",userId);

        return Jwts.builder()
                .setClaims(claims)
                // 만든 날짜
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // 만료 날짜
                .setExpiration(new Date(System.currentTimeMillis()+expireTimesMs))
                // 어떤키로 sign을 할지
                .signWith(SignatureAlgorithm.HS256,secretKey.getBytes())
                .compact()
                ;
    }
}
