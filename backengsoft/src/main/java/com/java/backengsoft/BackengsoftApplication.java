package com.java.backengsoft;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.backengsoft.entities.Investimento;
import com.java.backengsoft.entities.PreFixado;
import com.java.backengsoft.entities.Usuario;
import com.java.backengsoft.repositories.InvestimentoRepository;
import com.java.backengsoft.repositories.UsuarioRepository;

@SpringBootApplication
public class BackengsoftApplication implements CommandLineRunner{

	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private InvestimentoRepository investimentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackengsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario user = new Usuario("claudia", null, null, null, null);
		Investimento investimento1 = new PreFixado(null, 0, null, 0, null, null, null, null, user, null);
		
		investimento1.setUsuario(user);
		user.addInvestimento(investimento1);
		
		usuarioRepository.save(user);
		investimentoRepository.save(investimento1);
		
	}

}
