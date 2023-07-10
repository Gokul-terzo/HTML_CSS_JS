package com.example.springMVC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
@Configuration
public class Security {
    //add support for jdbc
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled from users where username=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, role from authorities where username=?");
        return jdbcUserDetailsManager;
    }
//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/employees").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
                        .requestMatchers(HttpMethod.GET, "/employee/**").hasAnyRole("ADMIN","EMPLOYEE","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/employee/new").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/employee/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employee/**").hasRole("ADMIN")
                        .requestMatchers("/register").permitAll()
        );
        //USE HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());
        //DISABLE CROSS SITE REQUEST FORGERY(CSRF)
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
