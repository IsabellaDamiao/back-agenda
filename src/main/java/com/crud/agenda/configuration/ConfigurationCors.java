package com.crud.agenda.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ConfigurationCors {
	
		  public void addCorsMappings(CorsRegistry registry) {
		    registry.addMapping("/agenda/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods(HttpMethod.PUT.name(),  HttpMethod.DELETE.name())
				.allowCredentials(false).maxAge(3600);
		   }
	

}
