package com.brandolkuete.ScolarWebRest;

import com.brandolkuete.ScolarWebRest.dto.RoleDto;
import com.brandolkuete.ScolarWebRest.dto.UseDto;
import com.brandolkuete.ScolarWebRest.service.AccountService;
import com.brandolkuete.ScolarWebRest.service.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScolarWebRestApplication implements CommandLineRunner {
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(ScolarWebRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		accountService.enregistrerUser(new UseDto("admin","1234",null));
		accountService.enregistrerUser(new UseDto("user","1234",null));

		accountService.enregistrerRole(new RoleDto("ADMIN"));
		accountService.enregistrerRole(new RoleDto("USER"));

		accountService.addRoleToUser("admin","ADMIN");
		accountService.addRoleToUser("admin","USER");
		accountService.addRoleToUser("user","USER");
	}
}
