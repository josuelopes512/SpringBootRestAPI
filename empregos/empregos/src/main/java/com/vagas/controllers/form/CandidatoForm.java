package com.vagas.controllers.form;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.vagas.models.Candidato;
import com.vagas.models.Curriculo;
import com.vagas.repository.CurriculoRepository;

public class CandidatoForm {

    @NotNull @NotEmpty @Length(min = 25)
    private String nome;
    @NotNull @NotEmpty @Length(min = 25)
    private String curriculoEmail;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurriculoEmail() {
        return this.curriculoEmail;
    }

    public void setCurriculoEmail(String curriculoEmail) {
        this.curriculoEmail = curriculoEmail;
    }

	public Candidato converter(CurriculoRepository curriculoRepository) {
        Curriculo curriculo = curriculoRepository.findByEmail(curriculoEmail);
		return new Candidato(nome, curriculo);
	}

}
