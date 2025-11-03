package BuldingWeb.example.nhom13.Configurations;

import BuldingWeb.example.nhom13.Filters.JwtTokenFliter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

public class WebSecurityConfig {

    @Autowired
    private JwtTokenFliter jwtTokenFliter;

    @Value("${api.prefix}")
    private String apiPrefix;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFliter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers(
                                    String.format("%s/dangnhap",apiPrefix),
                                    String.format("%s/dangky",apiPrefix),
                                    String.format("%s/search",apiPrefix)
                            )
                            .permitAll()
                            .requestMatchers(GET,String.format("%s/admin/bds/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(PUT,String.format("%s/admin/bds/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(POST,String.format("%s/admin/bds/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,String.format("%s/admin/bds/**",apiPrefix)).hasAnyRole("ADMIN")
                            .anyRequest().authenticated();

                });
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
