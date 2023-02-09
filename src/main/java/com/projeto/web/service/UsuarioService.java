package com.projeto.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.web.model.Usuario;
import com.projeto.web.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;


    public List<Usuario>findAll(){
        return repository.findAll();
    }
  

    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();

     
    }

    public Usuario insert(Usuario obj){
        return repository.save(obj);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

}
