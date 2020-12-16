package com.vagas.dto;

import com.vagas.models.Candidato;

import java.util.List;
import java.util.stream.Collectors;


public class CandidatoDto{
    private Long id;
    private String nome;

    public CandidatoDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public static List<CandidatoDto> converter(List<Candidato> candidatos) {
        return candidatos.stream().map(CandidatoDto::new).collect(Collectors.toList());
    }
}
