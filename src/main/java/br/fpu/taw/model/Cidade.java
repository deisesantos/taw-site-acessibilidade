package br.fpu.taw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Estado estado;
	
	@OneToMany
	private List<Bairro> bairros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}

}
