package com.crud.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.agenda.domian.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	
	@Query("SELECT obj FROM Agenda obj WHERE obj.favorito = false")
	List<Agenda> findAllOpen();

	@Query("SELECT obj FROM Agenda obj WHERE obj.favorito = true")
	List<Agenda> findAllClose();
	
}
