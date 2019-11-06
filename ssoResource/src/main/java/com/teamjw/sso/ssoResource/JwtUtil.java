package com.teamjw.sso.ssoResource;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {

    private CookieUtil cookieUtil;
    public void setCookieUtil(CookieUtil cookieUtil)
    {
        this.cookieUtil = cookieUtil;
    }
    public CookieUtil getCookieUtil()
    {
        return this.cookieUtil;
    }

    public String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }

    public String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){
        //String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        String token = cookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) return null;
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    }
}
