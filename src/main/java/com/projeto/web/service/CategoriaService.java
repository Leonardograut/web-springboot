package com.projeto.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.web.model.Categoria;
import com.projeto.web.repository.CategoriaRepository;


@Service
public class CategoriaService {
    
@Autowired
private  CategoriaRepository categoriaRepository;


    public List<Categoria>findAll(){
        return categoriaRepository.findAll();
    }
  

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.get();

     
    }

}
