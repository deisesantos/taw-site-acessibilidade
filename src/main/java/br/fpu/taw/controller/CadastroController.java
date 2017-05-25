package br.fpu.taw.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fpu.taw.model.Cadastro;
import br.fpu.taw.service.CadastroService;

@RestController
@RequestMapping(value="/api/v1/cadastro")
public class CadastroController {
	
	@Autowired
	CadastroService cadastroService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Cadastro>> listar() {
		return new ResponseEntity<>(cadastroService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Cadastro> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(cadastroService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cadastro> criar(@RequestBody Cadastro cadastro) {
		return new ResponseEntity<>(cadastroService.criar(cadastro), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cadastro> atualizar(@RequestBody Cadastro cadastro) {
		return new ResponseEntity<>(cadastroService.atualizar(cadastro), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		cadastroService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
