package com.projeto.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.web.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @GetMapping
    public ResponseEntity<Usuario>findAll(){
        Usuario u = new Usuario(1L,"Maria","maria@gmail.com","11111111","124556");
         return ResponseEntity.ok().body(u);
    }
}
