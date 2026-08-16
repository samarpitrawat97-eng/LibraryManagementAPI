package com.samarpit.LibraryManagementSystemAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless REST APIs
                .authorizeHttpRequests(auth -> auth
                        // Allow anyone to access the login/register endpoints and Swagger UI
                        .requestMatchers("/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()

                        // Only Admins can Add, Update, or Delete books
                        .requestMatchers(HttpMethod.POST, "/api/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("ADMIN")

                        // Any other request must be authenticated (logged in)
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // We use JWTs, not sessions
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Run our JWT filter first

        return http.build();
    }
}