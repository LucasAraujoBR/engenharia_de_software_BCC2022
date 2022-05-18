package com.sotckSystem.Stock.service;

import com.sotckSystem.Stock.model.Usuario;
import com.sotckSystem.Stock.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll(){
        return repository.findAll();
    }


    public Usuario findByCpf(String user) {
        return repository.findByCpf(user);
    }

    public void save(Usuario usuario) {
        repository.save(usuario);
    }
}
