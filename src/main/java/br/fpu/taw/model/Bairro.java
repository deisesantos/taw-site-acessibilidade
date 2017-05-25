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
public class Bairro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Cidade cidade;
	
	@OneToMany
	private List<Estabelecimento> estabelecimentos;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", nome=" + nome + ", cidade=" + cidade + "]";
	}
	
}
