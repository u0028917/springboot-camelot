package com.camelot.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 签名 拦截器配置
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Bean
    public InterceptorInterceptor interceptorInterceptor() {
        return new InterceptorInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html");
    }
}
