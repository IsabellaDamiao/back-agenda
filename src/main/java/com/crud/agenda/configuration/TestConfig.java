package com.crud.agenda.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.crud.agenda.service.DBService;

@Configuration
@Profile("teste")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instancia() {
		this.dbService.instanciaBaseDados();
		return true;	
	}

}
