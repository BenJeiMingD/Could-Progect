package com.mashibing.Corsconfig;
//当通过文件配置跨域请求时，则配置的是全局
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class Corsconfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 设置属性
        // 允许跨域请求的地址，*表示所有
        corsConfiguration.addAllowedOrigin("*");
        //  跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        //  跨域的请求方法
        corsConfiguration.addAllowedMethod("*");
        // 在跨域请求的时候使用同一个 Session
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置 可以访问的地址
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
