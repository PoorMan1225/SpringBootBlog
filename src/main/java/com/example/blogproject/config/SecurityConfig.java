package com.example.blogproject.config;

import com.example.blogproject.config.auth.PrincipalDetail;
import com.example.blogproject.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.PasswordManagementConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) // Service 단에서 인증 실행 전에 뭔가 처리해야 한다면 이 어노테이션이 필요하다.
@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private final PrincipalDetailService principalDetailService;

    @Bean // 우리가 필요한 객체를 ioc 메모리에 띄우는 역할을 한다.
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
        return builder.userDetailsService(principalDetailService).passwordEncoder(encode()).and().build();
    }

    // WebSeucurity adapter 가 deprecated  되어서 filterChain 을 등록해야 한다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/loginForm")
                .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 로그인을 가로 챈다.(대신 해준다)
                .defaultSuccessUrl("/");
        return http.build();
    }
}

