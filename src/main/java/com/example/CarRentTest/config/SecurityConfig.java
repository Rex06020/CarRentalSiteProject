package com.example.CarRentTest.config;

import com.example.CarRentTest.JWT.JwtAuthenticationFilter;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import com.example.CarRentTest.Service.CustomUserDetailsService;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

// 標記這是一個配置類
@Configuration
// 啟用 Web 安全性
@EnableWebSecurity
public class SecurityConfig {

    // 注入 JWT 認證過濾器
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    // 注入自定義的用戶詳情服務
    @Autowired
    private CustomUserDetailsService userDetailsService;

    // 配置認證提供者
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // 創建一個 DaoAuthenticationProvider 實例
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        // 設置自定義的 UserDetailsService
        authProvider.setUserDetailsService(userDetailsService);
        // 返回配置好的認證提供者
        return authProvider;
    }

    // 配置認證管理器
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // 配置安全過濾鏈
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**","/api/**", "/signup", "/login", "/", "/index", "/menu","/test", "/static/**", "/*.html",  "/js/**", "/css/**").permitAll()
                .requestMatchers("/api/validate-token", "/menu").authenticated()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    
        return http.build();
    } */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers( "/api/login", "/api/logout", "/api/signup", "/api/index", "/api/validate-token", "/signup", "/api/membership","/api/updateinfo","/carrent/paymentResult","/bank/paymentcenter/cnt/twqr/**","/carrent/forOrder?**").permitAll()
        //.requestMatchers(HttpMethod.POST, "/carrent/paymentResult").permitAll()
        //.requestMatchers(HttpMethod.GET, "/carrent/paymentResult").permitAll()
        .requestMatchers("/external-api/**").permitAll() // 新增這行來允許外部 API 的回調
        .requestMatchers("/carrent/searchPlace").authenticated()//需要登入的api
        .requestMatchers("/car/queryPage").authenticated()//需要登入的api
        
        .requestMatchers("/carrent/searchPlace2").authenticated()//測試用
        
        .requestMatchers("/carrent/order2").authenticated()
        .requestMatchers("/carrent/payment").authenticated()
        //.requestMatchers("/carrent/paymentResult").authenticated()
        .requestMatchers("/carrent/forOrder").authenticated()
        .requestMatchers("/carrent/forOrderDetail").authenticated()
        .anyRequest().authenticated()
        )
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:8080","https://payment-stage.ecpay.com")); // React 應用的 URL
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}


