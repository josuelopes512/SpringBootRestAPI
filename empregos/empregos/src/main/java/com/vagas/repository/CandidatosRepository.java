package com.vagas.repository;

import java.util.List;

import com.vagas.models.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatosRepository extends JpaRepository<Candidato, Long>{

	List<Candidato> findByCurriculoEmail(String curriculoEmail);
    
}
