package com.example.springsec1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEnc {
    @Bean
    protected PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
