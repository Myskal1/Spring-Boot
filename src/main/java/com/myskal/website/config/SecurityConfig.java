package com.myskal.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));

        http.authorizeHttpRequests(
                req -> req
                        .requestMatchers(HttpMethod.POST,"/api/v1/post/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/auth/register").anonymous()
                        .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        String userPassword = passwordEncoder().encode("user");
        String adminPassword = passwordEncoder().encode("admin");


        UserDetails user = User.builder()
                .username("user")
                .password(userPassword)
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(adminPassword)
                .roles("USER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user, admin);
    }
}
