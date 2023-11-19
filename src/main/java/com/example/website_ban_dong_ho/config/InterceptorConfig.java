package com.example.website_ban_dong_ho.config;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.interceptor.CartInterceptor;
import com.example.website_ban_dong_ho.interceptor.CategoryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    CategoryInterceptor categoryInterceptor;

    @Autowired
    CartInterceptor cartInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(categoryInterceptor)
                .addPathPatterns("/**")
//                .excludePathPatterns("/")
        ;
        registry.addInterceptor(cartInterceptor)
                .addPathPatterns("/**");
    }
}
