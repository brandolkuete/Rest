package com.brandolkuete.ScolarWebRest.dto;

import lombok.Data;

@Data
public class EleveDTO extends PersonneDTO{
	
	private String niveau;
	private String filiere;
	
	
	public EleveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EleveDTO(String niveau, String filiere) {
		this.niveau = niveau;
		this.filiere = filiere;
	}

	public EleveDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite, String addresse, int age, boolean active, String niveau, String filiere) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age, active);
		this.niveau = niveau;
		this.filiere = filiere;
	}
}
