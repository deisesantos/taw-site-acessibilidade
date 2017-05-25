package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Estabelecimento;
import br.fpu.taw.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public List<Estabelecimento> listar() {
		return estabelecimentoRepository.findAll();
	}
	
	public Estabelecimento buscarPorRegistro(String registro) {
		return estabelecimentoRepository.findOne(registro);
	}

	public Estabelecimento salvar(Estabelecimento estabelecimento) {
		if (estabelecimento == null || estabelecimento.getId() == null) {
			throw new IllegalArgumentException();
		}
		return estabelecimentoRepository.save(estabelecimento);
	}
	
	public Estabelecimento criar(Estabelecimento estabelecimento) {
		// nesse caso a logica é a mesma
		return salvar(estabelecimento);
	}

	public Estabelecimento atualizar(Estabelecimento estabelecimento) {
		// nesse caso a logica é a mesma
		return salvar(estabelecimento);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		estabelecimentoRepository.delete(registro);
	}

}
