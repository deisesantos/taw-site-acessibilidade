package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Cadastro;
import br.fpu.taw.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	public List<Cadastro> listar() {
		return cadastroRepository.findAll();
	}
	
	public Cadastro buscarPorRegistro(String registro) {
		return cadastroRepository.findOne(registro);
	}

	public Cadastro salvar(Cadastro cadastro) {
		if (cadastro == null || cadastro.getId() == null) {
			throw new IllegalArgumentException();
		}
		return cadastroRepository.save(cadastro);
	}
	
	public Cadastro criar(Cadastro cadastro) {
		// nesse caso a logica é a mesma
		return salvar(cadastro);
	}

	public Cadastro atualizar(Cadastro cadastro) {
		// nesse caso a logica é a mesma
		return salvar(cadastro);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		cadastroRepository.delete(registro);
	}

}
