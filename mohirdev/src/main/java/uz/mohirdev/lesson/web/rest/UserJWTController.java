package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.security.JwtProvider;
import uz.mohirdev.lesson.web.rest.vm.LoginVM;

import javax.validation.Valid;

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

    // jwt 9-qadam
    @PostMapping("/authenticate")
    public ResponseEntity authorize(@Valid @RequestBody LoginVM loginVM){
        // userni tekshiramiz
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getLogin(), loginVM.getPassword());
        //user mavjud bo'lsa tizimga kirdi va token yaratishga tayyor
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // bazaga murojaat qilmasdan turib usernameni olvolish
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // endigi navbat JWT yasaymiz
        String jwt = jwtProvider.createToken(loginVM.getLogin(), authentication);
        return ResponseEntity.ok(jwt);
    }
}







