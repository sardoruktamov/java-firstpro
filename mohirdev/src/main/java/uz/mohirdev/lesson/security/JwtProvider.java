package uz.mohirdev.lesson.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.mohirdev.lesson.entity.Role;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    //  JWTtoken 2-qadam buil.gradle faylida
    //  JWTtoken 3-qadam
    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private Long validityMilliSecond;

    // secret kalitimizni baytcodega o`tkazib olish (xavfsizlikni kuchaytirish)
    @PostConstruct
    protected void init(){
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    //  JWTtoken 10-qadam
    public String createToken(String username, Authentication authentication){
        // authentication ichidan role ni ajratib olish
        String roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        // JWTga solinishi kk bolgan malumotlar solindi(username va rules)
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);   // qoshimchasiga bu yerda userga tegishli barcha narsani kiritish mn
        // tokenni yashash muddatini qoyish
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityMilliSecond); //hozirgi vaqtdan boshlab 1 kun
//        Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, this.secret)   // HS256 algoritm boyicha shirflashni belgilash
//                .compact();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, this.secret)   // HS256 algoritm boyicha shirflashni belgilash
                .compact();

    }

    // parolni encode qilish (JWTtoken 6-qadam)
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
