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

import com.java.backengsoft.entities.Investimento;
import com.java.backengsoft.services.InvestimentoService;

@RestController
@RequestMapping(value="/investimentos")
public class InvestimentoResouce {

	@Autowired
	private InvestimentoService service;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Investimento> find(@PathVariable Integer id ) throws Exception {
		
		Investimento Investimento = service.find(id);
	
		return ResponseEntity.ok().body(Investimento);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Investimento obj) throws Exception{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Investimento obj, @PathVariable Integer id) throws Exception{
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
	public ResponseEntity<List<Investimento>> findAll() {
		
		List<Investimento> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
}
