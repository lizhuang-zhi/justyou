package com.cloud.justyou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //路由
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //addPathPatterns 要拦截的请求("/**")为所有
        //excludePathPatterns 排除 "/index.html","/","/user/login","/css/*","/js/**","/img/**"
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/css/*","/js/**","/img/**");
    }



}
