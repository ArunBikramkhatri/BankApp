package com.bankapplication.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class   SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/e-bank/user/**").hasRole("USER")
                .requestMatchers("/e-bank/admin/**").hasAnyRole("USER" , "ADMIN")
                .requestMatchers("/e-bank/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/e-bank/signIn")
                .loginProcessingUrl("/e-bank/login-process")
                .defaultSuccessUrl("/e-bank/user/dashboard")
                ;

        return http.build();
    }

}
