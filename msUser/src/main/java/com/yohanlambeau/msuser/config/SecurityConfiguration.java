package com.yohanlambeau.msuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers( "/signup","/signin","images/bootstrapupQUIZZ.min.css","images/fond_quizz1.jpg","images/stylesignupQUIZZ.css","images/stylesigninQUIZZ.css")  /*"/bootstrap.min.css", "/style.css", "/images/**", */
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/signin")
                                .permitAll().usernameParameter("email").defaultSuccessUrl("/index", true)
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
