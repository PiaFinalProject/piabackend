package com.teknokafalar.piabackend.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] AUTH_WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**"
    };
    private final UserDetailsService userDetailsService;


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize.antMatchers(HttpMethod.GET, "/api/**").permitAll()
                                .antMatchers("/api/auth/**").permitAll()
                                .antMatchers("/author/**").permitAll()
                                .antMatchers("/type/**").permitAll()
                                .antMatchers("/book/**").permitAll()
                                .antMatchers("/cartItem/**").permitAll()
                                .antMatchers("/cart/**").permitAll()
                                .antMatchers("/comment/**").permitAll()
                                .antMatchers("/users/**").permitAll()
                                .antMatchers("/order/**").permitAll()
                                .antMatchers("/api/**").permitAll()
                                .antMatchers("/subscriber/**").permitAll()
                                .antMatchers("/message/**").permitAll()
                                .antMatchers("/comment/**").permitAll()
                                .antMatchers("/book/**").permitAll()
                                .antMatchers(AUTH_WHITE_LIST).permitAll()
                                .anyRequest().authenticated()
                )
                .anonymous(anon -> anon.disable());

        http.sessionManagement(deneme -> deneme.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        return http.build();
    }




}
