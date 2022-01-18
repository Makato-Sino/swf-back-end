package com.sysu.swfbackend.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

//SpringSecurity配置跨域请求
@Configuration
public class CorsConfig {

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 1允许任何域名使用
//        corsConfiguration.addAllowedOrigin("*");
//        // 2允许任何头
//        corsConfiguration.addAllowedHeader("*");
//        // 3允许任何方法（post、get等）
//        corsConfiguration.addAllowedMethod("*");
//
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        return httpServletRequest -> {
            CorsConfiguration cfg = new CorsConfiguration();
            // 允许任何头
            cfg.addAllowedHeader("*");
            // 允许任何方法（post、get等）
            cfg.addAllowedMethod("*");
            // 允许域名使用
            cfg.addAllowedOrigin("http://localhost:8080");


            cfg.setAllowCredentials(true);
            cfg.checkOrigin("http://localhost:8080");
            return cfg;
        };
    }


}