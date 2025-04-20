package com.example.ProductManagement.config;

import com.example.ProductManagement.JWT.JwtAuthenticationFilter;
import com.example.ProductManagement.JWT.SessionTokenAuthenticationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    private final SessionTokenAuthenticationFilter sessionTokenAuthenticationFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, SessionTokenAuthenticationFilter sessionTokenAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.sessionTokenAuthenticationFilter = sessionTokenAuthenticationFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/courses").authenticated()
                .requestMatchers("/api/users/**", "/register").permitAll()
                .requestMatchers("/api/admin/**").permitAll()
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/api/users/register").permitAll()
                .requestMatchers("/api/users/login").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/home").authenticated()
                .requestMatchers("/enrollments/**").authenticated()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("/api/files/upload").permitAll()
                .requestMatchers("/upload").permitAll()
                .requestMatchers("/my-courses").authenticated()
                .requestMatchers("/error").permitAll()
                
                        
                          // Public authentication endpoints
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/courses",true)
                // .failureUrl("/login?error=true")
                .permitAll())

                .logout(logout -> logout.logoutUrl("/logout").permitAll())
                
                
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .addFilterBefore(sessionTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        

        return http.build();
    }
}