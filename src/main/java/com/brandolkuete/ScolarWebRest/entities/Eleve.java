package com.brandolkuete.ScolarWebRest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Eleve extends Personne {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String niveau;
	private String filiere;

	public Eleve(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite, String addresse, int age, boolean active, String niveau, String filiere) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age, active);
		this.niveau = niveau;
		this.filiere = filiere;
	}

	public Eleve() {
	}
}