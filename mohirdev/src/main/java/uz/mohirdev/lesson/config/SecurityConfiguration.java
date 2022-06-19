package uz.mohirdev.lesson.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import uz.mohirdev.lesson.security.JWTConfigere;
import uz.mohirdev.lesson.security.JwtProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    //46-dars
    private final JwtProvider jwtProvider;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService, JwtProvider jwtProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
    }

    //jwttoken 4 qadamda configure() kerak emas comentaryaga olamiz
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//  //              .inMemoryAuthentication()   //malumotlar bilan ishlash uhcun
//  //              .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN")
//  //              .and()
//  //              .withUser("user").password(passwordEncoder().encode("1234")).roles("USER");

//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()      // csrf o'chirildi
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/posts/paging/**").hasRole("USER") //**-bu cheksiz url yozish mumkin
        //        .antMatchers("/api/posts").hasRole("USER") // bu URLga USERga ruxsat berildi
                .antMatchers("/api/posts").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/api/posts").permitAll()  // barchaga ruxsat uchun URL
                .antMatchers("/api/register").permitAll()  // barchaga ruxsat uchun URL
                .antMatchers("/api/holidays").permitAll()  // barchaga ruxsat uchun URL
                .antMatchers("/api/authenticate").permitAll()  // barchaga ruxsat uchun URL
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()  //46-dars
                .apply(securityConfigurerAdapter());

    }

    //46-dars
    private JWTConfigere securityConfigurerAdapter(){
        return new JWTConfigere(jwtProvider);
    }

    //jwttoken 5 qadamda configure() kerak emas comentaryaga olamiz va JwtProvide.class ga yozib qoyamiz
    // parolni encode qilish
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
