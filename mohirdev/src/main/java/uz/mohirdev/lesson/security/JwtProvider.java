package uz.mohirdev.lesson.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${jwt.token.secret}")   //  JWTtoken 2-qadam
    private String secret;

    @Value("${jwt.token.validity}")        //  JWTtoken 2-qadam
    private String validityMilliSecond;
}
