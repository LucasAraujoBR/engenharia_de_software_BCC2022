package com.java.backengsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.backengsoft.entities.Investimento;
import com.java.backengsoft.repositories.InvestimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository repository;
	
	public Investimento find(Integer id) throws Exception {
		Optional<Investimento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new Exception(
				"Object not found! Id: " + id + ", Type: " + Investimento.class.getName()));

	}
	
	public Investimento insert(Investimento obj) throws Exception {
		Investimento investimento = find(obj.getId());

		if (investimento != null) {
			throw new Exception("The investimento's code is already saved on database");
		}
		obj.setId(null);
		return repository.save(obj);

	}
	
	public Investimento update(Investimento obj) throws Exception {
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
	public List<Investimento> findAll() {
		return repository.findAll();
	}

}
