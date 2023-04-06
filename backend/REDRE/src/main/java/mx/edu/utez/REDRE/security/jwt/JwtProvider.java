package mx.edu.utez.REDRE.security.jwt;

import io.jsonwebtoken.Jwts;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

public class JwtProvider {
    public final static Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    //public String generateToken(Authentication authentication) {}

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody()
                .getSubject();
    }
}
