package com.java.backengsoft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.backengsoft.entities.Usuario;
import com.java.backengsoft.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario find(Integer id) throws Exception {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new Exception(
				"Object not found! Id: " + id + ", Type: " + Usuario.class.getName()));

	}
	
	public Usuario insert(Usuario obj) throws Exception {
		Usuario usuario = find(obj.getId());

		if (usuario != null) {
			throw new Exception("The usuario's code is already saved on database");
		}
		obj.setId(null);
		return repository.save(obj);

	}
	
	public Usuario update(Usuario obj) throws Exception {
		find(obj.getId());
		
		return repository.save(obj);

	}
	
	public void delete(Integer id) throws Exception {
		find(id);
		try {
			repository.deleteById(id);
		} catch (Exception e ) {
			throw new Exception("Ação não realizada");
		}
	}
	public List<Usuario> findAll() {
		return repository.findAll();
	}
}
