package com.crud.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crud.agenda.domian.Agenda;
import com.crud.agenda.repository.AgendaRepository;
import com.crud.agenda.service.exception.ObjectNotFoundException;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository repository;
	
	public Agenda findById(Integer id) {
		Optional<Agenda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Agenda.class.getName()));
	}

	public List<Agenda> findAllOpen() {
		List<Agenda> list = repository.findAllOpen();
		return list;
	}
	
	public List<Agenda> findAllClosen() {
		List<Agenda> list = repository.findAllClose();
		return list;
	}

	public Agenda create(Agenda obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public List<Agenda> findAll() {
		List<Agenda> list = repository.findAll();
		return list;
	}

	public void delete(Integer id) {
		repository.deleteById(id);		
	}

	public Agenda update(Integer id, Agenda obj) {
		Agenda newObj = findById(id);
		newObj.setName(obj.getName());
		newObj.setPhone(obj.getPhone());
		newObj.setSurname(obj.getSurname());
		newObj.setFavorito(obj.isFavorito());
		return repository.save(newObj);
	}
}
