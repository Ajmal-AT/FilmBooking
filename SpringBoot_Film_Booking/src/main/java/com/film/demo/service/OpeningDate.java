package com.film.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.demo.beans.dateoperation;


@Repository
public interface OpeningDate extends JpaRepository<dateoperation, Long> {

}
