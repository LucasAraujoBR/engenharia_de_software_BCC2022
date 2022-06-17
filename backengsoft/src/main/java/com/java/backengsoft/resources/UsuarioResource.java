package com.java.backengsoft.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.backengsoft.entities.Usuario;
import com.java.backengsoft.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id ) throws Exception {
		
		Usuario Usuario = service.find(id);
	
		return ResponseEntity.ok().body(Usuario);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) throws Exception{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id) throws Exception{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		
		List<Usuario> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
