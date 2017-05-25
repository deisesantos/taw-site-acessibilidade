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

import br.fpu.taw.model.Rua;
import br.fpu.taw.service.RuaService;

@RestController
@RequestMapping(value="/api/v1/rua")
public class RuaController {
	
	@Autowired
	RuaService ruaService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Rua>> listar() {
		return new ResponseEntity<>(ruaService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Rua> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(ruaService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Rua> criar(@RequestBody Rua rua) {
		return new ResponseEntity<>(ruaService.criar(rua), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Rua> atualizar(@RequestBody Rua rua) {
		return new ResponseEntity<>(ruaService.atualizar(rua), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		ruaService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
