package com.projeto.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projeto.web.model.Produto;

import com.projeto.web.repository.ProdutoRepository;


@Service
public class ProdutoService {
    
@Autowired
private  ProdutoRepository  produtoRepository;


    public List<Produto>findAll(){
        return produtoRepository.findAll();
    }
  

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.get();

     
    }

}
