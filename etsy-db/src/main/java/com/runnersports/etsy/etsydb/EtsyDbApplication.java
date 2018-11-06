package com.runnersports.etsy.etsydb;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableBatchProcessing
public class EtsyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsyDbApplication.class, args);
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public FilterRegistrationBean corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost");
	    config.addAllowedOrigin("http://localhost:4200");
	    config.addAllowedHeader("Content-Type");
	    config.addAllowedHeader("Cache-Control");
	    config.addAllowedHeader("Pragma");
	    config.addAllowedHeader("X-Requested-With");
	    config.addAllowedHeader("Accept");	    
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new org.springframework.web.filter.CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}	}
