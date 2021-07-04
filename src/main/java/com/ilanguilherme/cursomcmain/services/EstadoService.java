package com.ilanguilherme.cursomcmain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilanguilherme.cursomcmain.domain.Estado;
import com.ilanguilherme.cursomcmain.repositories.EstadoRepository;
import com.ilanguilherme.cursomcmain.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public Estado buscar(Integer id){
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotrando! ID: " + id + ", Tipo: " + Estado.class.getName()
			) );
	}

}
