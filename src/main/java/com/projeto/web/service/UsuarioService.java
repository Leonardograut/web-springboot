package com.projeto.web.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.web.model.Usuario;
import com.projeto.web.repository.UsuarioRepository;
import com.projeto.web.service.exception.ControlerNotFoundException;
import com.projeto.web.service.exception.DatabaseException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;


    public List<Usuario>findAll(){
        return repository.findAll();
    }
  

    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ControlerNotFoundException(id));

     
    }

    public Usuario insert(Usuario obj){
        return repository.save(obj);
    }


    public void delete(Long id){
        try{
        repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
           throw new  ControlerNotFoundException(id);
        }catch(DataIntegrityViolationException e){
             throw new DatabaseException(e.getMessage());
        }
    }


    public Usuario update (Long id, Usuario obj){
       
        try{

        
        Usuario entity = repository.getReferenceById(id);
         updateData(entity,obj);
         return repository.save(entity);
        }catch(EntityNotFoundException e){
           
            throw new  ControlerNotFoundException(id);
        }
        }


    private void updateData(Usuario entity, Usuario obj) {
         entity.setNome(obj.getNome());
         entity.setEmail(obj.getEmail());
         entity.setTelefone(obj.getTelefone());

    }
}
