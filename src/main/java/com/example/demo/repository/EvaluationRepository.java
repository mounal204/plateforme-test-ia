package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Evaluationentity;

public interface EvaluationRepository
extends JpaRepository<Evaluationentity, Long> {
	
}
