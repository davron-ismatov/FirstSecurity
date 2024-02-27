package com.example.springsec1.config;

import com.example.springsec1.entity.Permission;
import com.example.springsec1.entity.Roles;
import com.example.springsec1.repository.UserRepository;
import com.example.springsec1.service.MyUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MyUsersService service;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(value ->{
                    value.requestMatchers("/admin/**").hasAuthority(Permission.ADD.name())
                            .requestMatchers("/register/**").permitAll()
                            .requestMatchers("/").permitAll()
                    .anyRequest()
                    .authenticated();
                })
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


   @Bean
   public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setUserDetailsService(service);
       provider.setPasswordEncoder(passwordEncoder);
       return provider;
   }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return  configuration.getAuthenticationManager();
    }
}
