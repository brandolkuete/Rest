package com.brandolkuete.ScolarWebRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class UseDto {
	
	private String username;
	private String password;
	private List<RoleDto> roles;
}
