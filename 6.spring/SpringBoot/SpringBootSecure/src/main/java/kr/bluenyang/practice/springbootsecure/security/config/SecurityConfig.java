package kr.bluenyang.practice.springbootsecure.security.config;

import kr.bluenyang.practice.springbootsecure.jwt.domain.JwtProperties;
import kr.bluenyang.practice.springbootsecure.jwt.filter.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
// Spring Security가 제공하는 기본 Web Security 구성 대신 사용자 정의 구성을 사용하도록 지정
@EnableWebSecurity
@RequiredArgsConstructor
@EnableConfigurationProperties(JwtProperties.class)
public class SecurityConfig {
    // private final UserDetailsService userDetailsService;
    private final AuthenticationFilter authenticationFilter;

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

    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authCfg) throws Exception {
        return authCfg.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        sessionManagement ->
                                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).authorizeHttpRequests(
                        authorizeRequests ->
                                authorizeRequests.requestMatchers(HttpMethod.POST, "/login")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated() // 허가된 요청 외에 나머지 모든 요청은 인증 요구
                ).addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}