package com.cefet.backendTrabalhoFinal.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cefet.backendTrabalhoFinal.security.JwtAuthenticationFilter;
import com.cefet.backendTrabalhoFinal.services.UsuarioDetailsService;

// Kazeir: Gerencie as permições

@Configuration
public class SecurityConfiguration {
    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Acesso ao H2 Console

                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Acesso
                                                                                                              // ao
                                                                                                              // Swagger
                                                                                                              // UI

                        .requestMatchers(HttpMethod.POST, "/auth").permitAll() // Permitir login de usuário

                        // acesso as imagens salvas
                        .requestMatchers(HttpMethod.GET, "/imagens/**").permitAll()

                        // Regras de Autorização para ARQUIVOS
                        .requestMatchers(HttpMethod.POST, "/imagens/upload").hasAnyRole("USER", "ADMIN")

                        // Regras de Autorização para USUARIO
                        .requestMatchers(HttpMethod.GET, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").permitAll()

                        // Regras de Autorização para JOGO
                        .requestMatchers(HttpMethod.GET, "/jogos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/jogos/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/jogos").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/jogos/{id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/jogos/{id}").hasAnyRole("USER", "ADMIN")

                        // Regras de Autorização para FRAME
                        .requestMatchers(HttpMethod.GET, "/frames").permitAll()
                        .requestMatchers(HttpMethod.GET, "/frames/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/frames").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/frames/{id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/frames/{id}").hasAnyRole("USER", "ADMIN")

                        // Todos os outros endpoints exigem autenticação
                        .anyRequest().authenticated())
                .headers(headers -> headers.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "https://ds-trabalho.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
