package kr.bluenyang.practice.springbootsecure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// Spring Security가 제공하는 기본 Web Security 구성 대신 사용자 정의 구성을 사용하도록 지정
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    // @Bean
    // public InMemoryUserDetailsManager userDetailService() {
    //     return new InMemoryUserDetailsManager(
    //             User.builder()
    //                     .username("user")
    //                     .password(passwordEncoder().encode("password"))
    //                     .roles("USER")
    //                     .build()
    //     );
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}