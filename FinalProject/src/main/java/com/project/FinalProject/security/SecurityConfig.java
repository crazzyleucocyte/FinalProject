package com.project.FinalProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
        	.cors((cors) -> cors.disable())
            .authorizeRequests()
                .requestMatchers("/").permitAll() // 로그인 페이지와 정적 리소스는 접근 허용
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers("/").hasRole("ADMIN")
                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
            .and()
            .formLogin()
                .loginPage("/") // 커스텀 로그인 페이지 설정
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home", true) // 로그인 성공 시 이동할 페이지
                .failureUrl("/login?error=true") // 로그인 실패 시 이동할 페이지
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login") // 로그아웃 성공 시 이동할 페이지
                .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호 암호화 설정
    }
    
    
    @Bean
    public UserDetailsService users() {
       UserDetails admin = User.builder()
             .username("admin")
             .password(passwordEncoder().encode("1234"))
             .roles("ADMIN")
             .build();
       
       return new InMemoryUserDetailsManager(admin);
    }
    
}
