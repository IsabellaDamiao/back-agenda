package com.crud.agenda.resouce;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.agenda.domian.Agenda;
import com.crud.agenda.service.AgendaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/agenda")
public class AgendaResource {
	
	
	@Autowired
	private AgendaService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agenda> findyById(@PathVariable Integer id) {
		Agenda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
		
	
	@GetMapping(value ="/open")
	public ResponseEntity<List<Agenda>> listOpen(){
	List<Agenda> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value ="/close")
	public ResponseEntity<List<Agenda>> listClose(){
	List<Agenda> list = service.findAllClosen();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Agenda>> listAll(){
	List<Agenda> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<Agenda> create(@RequestBody Agenda obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Agenda> update(@PathVariable Integer id, @RequestBody Agenda obj) {
		Agenda newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
		
	}
	
	

}
