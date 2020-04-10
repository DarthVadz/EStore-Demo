package com.tts.d22_GroovyStore_1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.d22_GroovyStore_1.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
	List<User> findUsersByRole(String role);
}
