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

import br.fpu.taw.model.Bairro;
import br.fpu.taw.service.BairroService;

@RestController
@RequestMapping(value="/api/v1/bairro")
public class BairroController {
	
	@Autowired
	BairroService bairroService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Bairro>> listar() {
		return new ResponseEntity<>(bairroService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Bairro> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(bairroService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Bairro> criar(@RequestBody Bairro bairro) {
		return new ResponseEntity<>(bairroService.criar(bairro), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Bairro> atualizar(@RequestBody Bairro bairro) {
		return new ResponseEntity<>(bairroService.atualizar(bairro), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		bairroService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
