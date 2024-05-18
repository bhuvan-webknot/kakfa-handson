package com.bhuvan.springsecurity.springsecuritydemo.config;

import com.bhuvan.springsecurity.springsecuritydemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    private User userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .("/public/**").permitAll() // Public routes
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN") // Routes accessible to USER and ADMIN
                .antMatchers("/admin/**").hasRole("ADMIN") // Routes accessible to ADMIN only
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .formLogin().permitAll() // Login form
                .and()
                .logout().permitAll(); // Logout endpoint
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

