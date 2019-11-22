package com.brandolkuete.ScolarWebRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandolkuete.ScolarWebRest.entities.Enseignant;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	public Enseignant findByNom(String nom);
	public Enseignant findByTelephone(String tel);
	public List<Enseignant> findAllByActive(boolean active);
}
