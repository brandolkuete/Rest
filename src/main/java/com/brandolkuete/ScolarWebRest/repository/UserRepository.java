package com.brandolkuete.ScolarWebRest.repository;

import com.brandolkuete.ScolarWebRest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUsername(String username);

	User findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}
