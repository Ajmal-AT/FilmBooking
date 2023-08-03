package com.film.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.demo.beans.MovieDetails;

@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, Long>{

	List<MovieDetails> findAllBymovieName(String movieName);
	

}
