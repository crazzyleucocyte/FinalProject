package com.project.FinalProject.config;

import com.project.FinalProject.service.MemberService;

import jakarta.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    private final MemberService memberService;

    public SecurityConfig(MemberService memberService) {
        this.memberService = memberService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        		.csrf((csrf) -> csrf.disable()) //웹보안
				.cors((cors) -> cors.disable()) //웹보안
                .authorizeHttpRequests(auth -> auth //권한설정
                		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                		.requestMatchers("/css/**","/js/**","/img/**").permitAll()
						.requestMatchers("/tosignup").permitAll()
                		.requestMatchers("/signup").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/home")
                        .defaultSuccessUrl("/home", true)
                        .usernameParameter("username")
                        .passwordParameter("password") 	
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                )
                .build();
    }
}
