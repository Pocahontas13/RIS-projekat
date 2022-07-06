package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Konobar;

public interface KonobarRepository extends JpaRepository<Konobar, Integer>{
	
}
