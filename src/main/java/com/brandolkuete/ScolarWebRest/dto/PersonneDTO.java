package com.brandolkuete.ScolarWebRest.dto;

import lombok.Data;


@Data
public class PersonneDTO {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String date_nais;
	private String nationalite;
	private String addresse;
	private int age;
	private boolean active;
	
	public PersonneDTO() {
		super();
	}

	public PersonneDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite, String addresse, int age, boolean active) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.date_nais = date_nais;
		this.nationalite = nationalite;
		this.addresse = addresse;
		this.age = age;
		this.active = active;
	}
}
