package com.brandolkuete.ScolarWebRest.dto;

import lombok.Data;

@Data
public class ReponseDto {
	
	private int statut;
	private String message;
	
	public ReponseDto() {
		super();
	}

	public ReponseDto(int statut, String message) {
		super();
		this.statut = statut;
		this.message = message;
	}
}
