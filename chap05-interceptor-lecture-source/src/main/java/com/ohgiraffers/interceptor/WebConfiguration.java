package com.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private StopWatchInterceptor stopWatchInterceptor;

    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor){
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    // 스프링한테 인터셉터라고 알려주는 애
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StopWatchInterceptor(new MenuService()))
                .addPathPatterns("/stopwatch");

    }


}
