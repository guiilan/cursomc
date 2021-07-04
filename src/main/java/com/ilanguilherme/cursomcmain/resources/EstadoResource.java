package com.ilanguilherme.cursomcmain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilanguilherme.cursomcmain.domain.Estado;
import com.ilanguilherme.cursomcmain.services.EstadoService;

@RestController
@RequestMapping(value="/estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?>find(@PathVariable Integer id) {
		Estado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping
	public List<Estado> buscarTodos(){
		return service.buscarTodos();
	}
	

}
