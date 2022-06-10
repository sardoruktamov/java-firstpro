package uz.mohirdev.lesson.web.rest;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.security.JwtProvider;

// jwt 7-qadam fayl yaratamiz..
@RestController
@RequestMapping("api")
public class UserJWTController {

    private final JwtProvider jwtProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserJWTController(JwtProvider jwtProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtProvider = jwtProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

//    @PostMapping("/authenticate")
}
