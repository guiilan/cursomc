package com.ilanguilherme.cursomcmain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilanguilherme.cursomcmain.domain.Categoria;
import com.ilanguilherme.cursomcmain.repositories.CategoriaRepository;
import com.ilanguilherme.cursomcmain.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encotrando! ID: " + id + ", Tipo: " + Categoria.class.getName()
				) );
	}
	
	public List<Categoria> buscarTodos(){
		return repo.findAll();
	}
	
}