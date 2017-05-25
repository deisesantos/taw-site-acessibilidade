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

import br.fpu.taw.model.Estado;
import br.fpu.taw.service.EstadoService;

@RestController
@RequestMapping(value="/api/v1/estado")
public class EstadoController {
	
	@Autowired
	EstadoService estadoService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Estado>> listar() {
		return new ResponseEntity<>(estadoService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Estado> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(estadoService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Estado> criar(@RequestBody Estado estado) {
		return new ResponseEntity<>(estadoService.criar(estado), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Estado> atualizar(@RequestBody Estado estado) {
		return new ResponseEntity<>(estadoService.atualizar(estado), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		estadoService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
