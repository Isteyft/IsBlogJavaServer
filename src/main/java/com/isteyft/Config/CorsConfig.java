package com.isteyft.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig implements WebMvcConfigurer  {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 设置允许跨域请求的域名
                .allowedHeaders("*") // 设置允许的请求头
                .allowCredentials(true) // 是否允许证书
                .allowedMethods("*") // 允许的方法
                .maxAge(3600); // 跨域允许时间
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true); // 允许携带凭据（cookies）
//
//        // 替换为允许的具体起源列表
//        config.addAllowedOrigin("http://localhost:8081");
//        config.addAllowedOrigin("https://localhost:8081");
//        config.addAllowedOrigin("http://localhost:90");
//        config.addAllowedOrigin("https://localhost:90");
//        config.addAllowedOrigin("http://isteyft.top");
//        config.addAllowedOrigin("https://isteyft.top");
//        config.addAllowedOrigin("http://www.isteyft.top");
//        config.addAllowedOrigin("https://www.isteyft.top");
//        config.addAllowedOrigin("http://47.113.104.178");
//        config.addAllowedOrigin("http://47.113.104.178");
//
//        config.addAllowedHeader("*"); // 允许所有头信息
//        config.addAllowedMethod("*"); // 允许所有HTTP方法
//
//        source.registerCorsConfiguration("/**", config); // 对所有路径应用CORS配置
//        return new CorsFilter(source);
//    }
}