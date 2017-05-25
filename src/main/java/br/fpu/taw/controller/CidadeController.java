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

import br.fpu.taw.model.Cidade;
import br.fpu.taw.service.CidadeService;

@RestController
@RequestMapping(value="/api/v1/cidade")
public class CidadeController {
	
	@Autowired
	CidadeService cidadeService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Cidade>> listar() {
		return new ResponseEntity<>(cidadeService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> buscarPorId(@PathVariable(required=true) String registro) {
		Cidade c = cidadeService.buscarPorRegistro(registro);
		c.getEstado().setCidades(null);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade) {
		return new ResponseEntity<>(cidadeService.criar(cidade), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cidade> atualizar(@RequestBody Cidade cidade) {
		return new ResponseEntity<>(cidadeService.atualizar(cidade), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		cidadeService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
