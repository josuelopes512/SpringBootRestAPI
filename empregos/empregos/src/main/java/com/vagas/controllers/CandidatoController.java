package com.vagas.controllers;

import java.net.URI;
import java.util.List;

import com.vagas.controllers.form.CandidatoForm;
import com.vagas.dto.CandidatoDto;
import com.vagas.models.Candidato;
import com.vagas.repository.CandidatosRepository;
import com.vagas.repository.CurriculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatosRepository candidatosRepository;

    @Autowired
    private CurriculoRepository curriculoRepository;

    @GetMapping
    public List<CandidatoDto> listaCandidatos(String curriculoEmail) {
        if (curriculoEmail == null) {
            List<Candidato> candidatos = candidatosRepository.findAll();
            return CandidatoDto.converter(candidatos);
        } else {
            List<Candidato> candidatos = candidatosRepository.findByCurriculoEmail(curriculoEmail);
            return CandidatoDto.converter(candidatos);
        }
        // Candidato candidato = new Candidato("nome", new Curriculo("email", "area",
        // 25D, 25, new ArrayList<Cursos>()));
        // return CandidatoDto.converter(Arrays.asList(candidato, candidato,
        // candidato));
    }

    @PostMapping
    public ResponseEntity<CandidatoDto> cadastrar(@RequestBody @Validated CandidatoForm form,
            UriComponentsBuilder uribuilder) {
        Candidato candidato = form.converter(curriculoRepository);
        candidatosRepository.save(candidato);


        URI uri = uribuilder.path("/topicos/{id}").buildAndExpand(candidato.getId()).toUri();
        return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
    }
}
