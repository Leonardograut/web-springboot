package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.web.model.Usuario;
import com.projeto.web.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
   
   @Autowired
   private  UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>>findAll(){
         List<Usuario> list = service.findAll();
         return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario>findByid(@PathVariable Long id){
        Usuario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
