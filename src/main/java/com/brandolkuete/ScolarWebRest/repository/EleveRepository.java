package com.brandolkuete.ScolarWebRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandolkuete.ScolarWebRest.entities.Eleve;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
	
	public Eleve findByMatricule(String matricule);
	List<Eleve> findAllByActive(boolean active);
}
