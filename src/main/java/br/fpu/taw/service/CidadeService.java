package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Cidade;
import br.fpu.taw.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	public Cidade buscarPorRegistro(String registro) {
		return cidadeRepository.findOne(registro);
	}

	public Cidade salvar(Cidade cidade) {
		if (cidade == null || cidade.getId() == null) {
			throw new IllegalArgumentException();
		}
		return cidadeRepository.save(cidade);
	}
	
	public Cidade criar(Cidade cidade) {
		// nesse caso a logica é a mesma
		return salvar(cidade);
	}

	public Cidade atualizar(Cidade cidade) {
		// nesse caso a logica é a mesma
		return salvar(cidade);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		cidadeRepository.delete(registro);
	}

}
