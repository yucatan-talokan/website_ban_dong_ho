package com.example.website_ban_dong_ho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "SELECT Email, Password FROM users WHERE Email = ?"
//        );
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "SELECT Email, Role FROM roles WHERE Email = ?"
//        );
//        return jdbcUserDetailsManager;
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails guest = User.builder()
                .username("guest")
                .password("{noop}123")
                .roles("GUEST")
                .build();
        UserDetails employee = User.builder()
                .username("employee")
                .password("{noop}123")
                .roles("GUEST", "EMPLOYEE")
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}123")
                .roles("GUEST", "EMPLOYEE", "MANAGER")
                .build();
        return new InMemoryUserDetailsManager(guest, employee, manager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                        config
                                .requestMatchers("/orders/checkout").hasAnyRole("GUEST", "EMPLOYEE", "MANAGER")
                                .requestMatchers("/orders/purchase").hasAnyRole("GUEST", "EMPLOYEE", "MANAGER")
                                .requestMatchers("/orders/list").hasAnyRole("GUEST", "EMPLOYEE", "MANAGER")
                                .requestMatchers("/orders/detail").hasAnyRole("GUEST", "EMPLOYEE", "MANAGER")
                                .anyRequest().permitAll()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authen")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
