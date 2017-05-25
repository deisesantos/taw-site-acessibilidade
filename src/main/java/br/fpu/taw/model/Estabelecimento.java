package br.fpu.taw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estabelecimento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private Integer num;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Rua rua;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Bairro bairro;

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", nome=" + nome + ", num=" + num + ", descricao=" + descricao + ", rua="
				+ rua + ", bairro=" + bairro + "]";
	}

}
