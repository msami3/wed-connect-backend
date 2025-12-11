package com.wedconnect.jwt.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Since you are building a backend for a separate frontend:
            .csrf(csrf -> csrf.disable()) 
            
            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Explicitly permit access to the /messages endpoint
                .requestMatchers("/messages").permitAll()
                // Require authentication for all other requests
                .anyRequest().authenticated()
            );

        return http.build();
    }
}