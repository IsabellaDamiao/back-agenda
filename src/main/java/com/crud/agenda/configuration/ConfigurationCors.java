package com.crud.agenda.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ConfigurationCors {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
	        return new WebMvcConfigurer() {
	                
	        	@Override
	                public void addCorsMappings(CorsRegistry registry) {
	                        registry.addMapping("/agenda/**")
	                                .allowedOrigins("http://localhost:4200")
	                                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                                .maxAge(3600);
	                }

	        };
	}
	

}
