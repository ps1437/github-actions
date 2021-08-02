package com.syscho.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

	private RequestInterceptor requestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(requestInterceptor);
	}

}
