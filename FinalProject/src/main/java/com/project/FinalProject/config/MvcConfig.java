package com.project.FinalProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.Value;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	private String classpath="C:/FinalProject/PACSStorage/";
    // 개발 시점에 사용 가능한 코드.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	  WebMvcConfigurer.super.addResourceHandlers(registry);
    	  
        registry
          .addResourceHandler("/PACSStorage/**")
				.addResourceLocations("file:///" + classpath);
	}
}