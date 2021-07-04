package com.ilanguilherme.cursomcmain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilanguilherme.cursomcmain.domain.Cliente;
import com.ilanguilherme.cursomcmain.repositories.ClienteRepository;
import com.ilanguilherme.cursomcmain.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encotrando! ID: " + id + ", Tipo: " + Cliente.class.getName()
				) );
	}
	
	public List<Cliente> buscarTodos(){
		return repo.findAll();
	} 
}
