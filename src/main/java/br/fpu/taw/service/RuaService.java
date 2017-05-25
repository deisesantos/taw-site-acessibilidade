package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Rua;
import br.fpu.taw.repository.RuaRepository;

@Service
public class RuaService {
	
	@Autowired
	RuaRepository ruaRepository;
	
	public List<Rua> listar() {
		return ruaRepository.findAll();
	}
	
	public Rua buscarPorRegistro(String registro) {
		return ruaRepository.findOne(registro);
	}

	public Rua salvar(Rua rua) {
		if (rua == null || rua.getId() == null) {
			throw new IllegalArgumentException();
		}
		return ruaRepository.save(rua);
	}
	
	public Rua criar(Rua rua) {
		// nesse caso a logica é a mesma
		return salvar(rua);
	}

	public Rua atualizar(Rua rua) {
		// nesse caso a logica é a mesma
		return salvar(rua);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		ruaRepository.delete(registro);
	}

}
