package com.vagas.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Curriculo implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 5759379610750463995L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String area;
    private Double intensaoSalarial;
    private int idade;
    @ManyToMany(mappedBy = "curriculo")
    private ArrayList<Cursos> cursos = new ArrayList<>();

    public Curriculo(){}

    public Curriculo(Long id, String email, String area, Double intensaoSalarial, int idade, ArrayList<Cursos> cursos){
        this.id = id;
        this.email = email;
        this.area = area;
        this.intensaoSalarial = intensaoSalarial;
        this.idade = idade;
        this.cursos = cursos;
    }

    public Curriculo(String email, String area, Double intensaoSalarial, int idade, ArrayList<Cursos> cursos){
        this.email = email;
        this.area = area;
        this.intensaoSalarial = intensaoSalarial;
        this.idade = idade;
        this.cursos = cursos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getIntensaoSalarial() {
        return this.intensaoSalarial;
    }

    public void setIntensaoSalarial(Double intensaoSalarial) {
        this.intensaoSalarial = intensaoSalarial;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Cursos> getCursos() {
        return this.cursos;
    }

    public void setCursos(ArrayList<Cursos> cursos) {
        this.cursos = cursos;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
            Curriculo other = (Curriculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
    }
}
