package com.brandolkuete.ScolarWebRest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Enseignant extends Personne {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String situationMat;
	private String specialite;
	private String grade;
	private String email;
	private String telephone;
	private double salaire;

	public Enseignant() {
	}

	public Enseignant(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite, String addresse, int age, boolean active, String situationMat, String specialite, String grade, String email, String telephone, double salaire) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age, active);
		this.situationMat = situationMat;
		this.specialite = specialite;
		this.grade = grade;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}
}
