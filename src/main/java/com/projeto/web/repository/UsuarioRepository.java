package com.projeto.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.web.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{
    
}
