package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.web.model.Categoria;

import com.projeto.web.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
 
    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>>findAll(){
         List<Categoria> list = categoriaService.findAll();
         return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findByid(@PathVariable Long id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);

    }


}
