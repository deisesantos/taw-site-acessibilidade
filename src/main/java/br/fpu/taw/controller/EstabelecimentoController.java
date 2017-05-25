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

import br.fpu.taw.model.Estabelecimento;
import br.fpu.taw.service.EstabelecimentoService;

@RestController
@RequestMapping(value="/api/v1/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	EstabelecimentoService estabelecimentoService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Estabelecimento>> listar() {
		return new ResponseEntity<>(estabelecimentoService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Estabelecimento> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(estabelecimentoService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Estabelecimento> criar(@RequestBody Estabelecimento estabelecimento) {
		return new ResponseEntity<>(estabelecimentoService.criar(estabelecimento), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Estabelecimento> atualizar(@RequestBody Estabelecimento estabelecimento) {
		return new ResponseEntity<>(estabelecimentoService.atualizar(estabelecimento), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		estabelecimentoService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
