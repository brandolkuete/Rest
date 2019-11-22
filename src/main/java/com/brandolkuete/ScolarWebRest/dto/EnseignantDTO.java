package com.brandolkuete.ScolarWebRest.dto;

import lombok.Data;

@Data
public class EnseignantDTO extends PersonneDTO{
	
	private String situationMat;
	private String specialite;
	private String grade;
	private String email;
	private String telephone;
	private double salaire;
	
	
	public EnseignantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnseignantDTO(String situationMat, String specialite, String grade, String email, String telephone, double salaire) {
		this.situationMat = situationMat;
		this.specialite = specialite;
		this.grade = grade;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}

	public EnseignantDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite, String addresse, int age, boolean active, String situationMat, String specialite, String grade, String email, String telephone, double salaire) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age, active);
		this.situationMat = situationMat;
		this.specialite = specialite;
		this.grade = grade;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}
}
