package com.projeto.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.web.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria,Long> {
    
}
