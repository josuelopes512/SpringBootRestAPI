package com.vagas.repository;

import com.vagas.models.Curriculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {

	Curriculo findByEmail(String curriculoEmail);

}
