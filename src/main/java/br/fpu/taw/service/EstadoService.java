package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Estado;
import br.fpu.taw.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	public Estado buscarPorRegistro(String registro) {
		return estadoRepository.findOne(registro);
	}

	public Estado salvar(Estado estado) {
		if (estado == null || estado.getId() == null) {
			throw new IllegalArgumentException();
		}
		return estadoRepository.save(estado);
	}
	
	public Estado criar(Estado estado) {
		// nesse caso a logica é a mesma
		return salvar(estado);
	}

	public Estado atualizar(Estado estado) {
		// nesse caso a logica é a mesma
		return salvar(estado);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		estadoRepository.delete(registro);
	}

}
