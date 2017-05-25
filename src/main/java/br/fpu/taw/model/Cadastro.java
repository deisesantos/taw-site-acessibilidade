package br.fpu.taw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private Date data_nascimento;
	
	@Column(nullable=false)
	private String cpf;
	
	private String email;
	
	private String senha;

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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", cpf=" + cpf
				+ ", email=" + email + ", senha=" + senha + "]";
	}
	
}