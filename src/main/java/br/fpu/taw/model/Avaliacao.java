package br.fpu.taw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String texto;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Cadastro pessoa;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Estabelecimento local;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Cadastro getPessoa() {
		return pessoa;
	}

	public void setPessoa(Cadastro pessoa) {
		this.pessoa = pessoa;
	}

	public Estabelecimento getLocal() {
		return local;
	}

	public void setLocal(Estabelecimento local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", texto=" + texto + ", pessoa=" + pessoa + ", local=" + local + "]";
	}
	
}
