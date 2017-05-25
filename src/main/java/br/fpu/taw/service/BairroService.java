package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Bairro;
import br.fpu.taw.repository.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	BairroRepository bairroRepository;
	
	public List<Bairro> listar() {
		return bairroRepository.findAll();
	}
	
	public Bairro buscarPorRegistro(String registro) {
		return bairroRepository.findOne(registro);
	}

	public Bairro salvar(Bairro bairro) {
		if (bairro == null || bairro.getId() == null) {
			throw new IllegalArgumentException();
		}
		return bairroRepository.save(bairro);
	}
	
	public Bairro criar(Bairro bairro) {
		// nesse caso a logica é a mesma
		return salvar(bairro);
	}

	public Bairro atualizar(Bairro bairro) {
		// nesse caso a logica é a mesma
		return salvar(bairro);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		bairroRepository.delete(registro);
	}

}
