package uz.mohirdev.lesson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()   //malumotlar bilan ishlash uhcun
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/posts/paging/**").hasRole("ADMIN") //**-bu cheksiz url yozish mumkin
        //        .antMatchers("/api/posts").hasRole("USER") // bu URLga USERga ruxsat berildi
//                .antMatchers("/api/posts").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/posts").permitAll()  // barchaga ruxsat uchun URL
                .antMatchers("/api/register").permitAll()  // barchaga ruxsat uchun URL
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    // parolni encode qilish
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
