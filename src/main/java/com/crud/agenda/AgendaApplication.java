package com.crud.agenda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
	@SuppressWarnings("deprecation")
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		
        return new WebMvcConfigurerAdapter() {
        	
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/agenda/**").allowedOrigins("http://localhost:4200").allowedMethods("PUT", "DELETE",
                        "GET", "POST");
            }
        };
    }

}


