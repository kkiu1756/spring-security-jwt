package com.jhjeong.springsecurityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true); // 서버가 응답 시 json을 자바스크립트에서 처리할 수 있게 할 지
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*"); // 모든 header에 응답 허용
    config.addAllowedMethod("*"); // 모든 타입의 요청 허용
    source.registerCorsConfiguration("/api/**", config);
    return new CorsFilter(source);
  }
}
