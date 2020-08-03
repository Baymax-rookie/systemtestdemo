package org.systemtest.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 12589
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsconfig=new CorsConfiguration();
        /*
         * 放行原始域
         * */
        corsconfig.addAllowedOrigin("*");

        corsconfig.setAllowCredentials(true);

        corsconfig.addAllowedMethod("*");
        corsconfig.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource basedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
        basedCorsConfigurationSource.registerCorsConfiguration("/*",corsconfig);
        return new CorsFilter(basedCorsConfigurationSource);
    }
}
