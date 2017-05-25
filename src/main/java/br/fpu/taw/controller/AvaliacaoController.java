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

import br.fpu.taw.model.Avaliacao;
import br.fpu.taw.service.AvaliacaoService;

@RestController
@RequestMapping(value="/api/v1/avaliacao")
public class AvaliacaoController {
	
	@Autowired
	AvaliacaoService avaliacaoService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Avaliacao>> listar() {
		return new ResponseEntity<>(avaliacaoService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Avaliacao> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(avaliacaoService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Avaliacao> criar(@RequestBody Avaliacao patrulha) {
		return new ResponseEntity<>(avaliacaoService.criar(patrulha), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Avaliacao> atualizar(@RequestBody Avaliacao avaliacao) {
		return new ResponseEntity<>(avaliacaoService.atualizar(avaliacao), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		avaliacaoService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
