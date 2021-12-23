package com.crud.agenda.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.agenda.domian.Agenda;
import com.crud.agenda.repository.AgendaRepository;

@Service
public class DBService {

	@Autowired
	private AgendaRepository agendaRepository;
	
	public void instanciaBaseDados() {

		Agenda a1 = new Agenda(null, "Isabella", "Damião", "35353535");
		Agenda a2 = new Agenda(null, "Gabriella", "Damião", "3232323232");
		Agenda a3 = new Agenda(null, "Cristiane", "Damião", "3131313131");

		agendaRepository.saveAll(Arrays.asList(a1, a2, a3));
	}

}
