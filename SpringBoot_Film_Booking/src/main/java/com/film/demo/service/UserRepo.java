package com.film.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.film.demo.beans.user;

@Repository
public interface UserRepo extends JpaRepository<user, Long> {
	
	public user findByEmailAndPassword(String email, String password);

}
