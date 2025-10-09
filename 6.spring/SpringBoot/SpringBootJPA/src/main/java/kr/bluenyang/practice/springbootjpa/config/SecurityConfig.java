package kr.bluenyang.practice.springbootjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 스프링 기본 인증 작업 끄기
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // 모든 요청 인증없이 허용)
                        .anyRequest().authenticated() // 그 외의 요청은 인증 필요
                )
                .csrf(AbstractHttpConfigurer::disable) // csrf 토큰 없이도 로그인 가능
                .formLogin(FormLoginConfigurer::disable) // 스프링시큐리티 제공 기본 로그인 사용종료
                .headers(headerConfig ->
                        headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)); // iframe페이지는 허가하지 않음(X-Frame-Options 응답헤더 : DENY로 설정)
        return http.build();
    }
}
