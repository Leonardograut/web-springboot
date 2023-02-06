package com.projeto.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.web.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {
    
}
