package com.projeto.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.web.model.Usuario;
import com.projeto.web.repository.UsuarioRepository;
import com.projeto.web.service.exception.ControlerNotFoundException;

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
        repository.deleteById(id);
    }


    public Usuario update (Long id, Usuario obj){
        Usuario entity = repository.getReferenceById(id);
         updateData(entity,obj);
         return repository.save(entity);
    }


    private void updateData(Usuario entity, Usuario obj) {
         entity.setNome(obj.getNome());
         entity.setEmail(obj.getEmail());
         entity.setTelefone(obj.getTelefone());

    }
}
