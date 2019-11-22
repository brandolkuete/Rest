package com.brandolkuete.ScolarWebRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandolkuete.ScolarWebRest.entities.Personne;

import java.util.List;


public interface PersonneRepository<T extends Personne> extends JpaRepository<Personne, Long>{
}
