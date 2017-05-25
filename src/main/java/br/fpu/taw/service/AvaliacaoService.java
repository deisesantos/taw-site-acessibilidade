package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Avaliacao;
import br.fpu.taw.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	public List<Avaliacao> listar() {
		return avaliacaoRepository.findAll();
	}
	
	public Avaliacao buscarPorRegistro(String registro) {
		return avaliacaoRepository.findOne(registro);
	}

	public Avaliacao salvar(Avaliacao avaliacao) {
		if (avaliacao == null || avaliacao.getId() == null) {
			throw new IllegalArgumentException();
		}
		return avaliacaoRepository.save(avaliacao);
	}
	
	public Avaliacao criar(Avaliacao avaliacao) {
		// nesse caso a logica é a mesma
		return salvar(avaliacao);
	}

	public Avaliacao atualizar(Avaliacao avaliacao) {
		// nesse caso a logica é a mesma
		return salvar(avaliacao);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		avaliacaoRepository.delete(registro);
	}

}
