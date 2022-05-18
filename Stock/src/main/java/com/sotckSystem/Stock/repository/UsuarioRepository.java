package com.sotckSystem.Stock.repository;

import com.sotckSystem.Stock.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByCpf(String user);
}
