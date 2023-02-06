package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.web.model.Produto;

import com.projeto.web.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
   
   @Autowired
   private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>>findAll(){
         List<Produto> list = produtoService.findAll();
         return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Produto>findByid(@PathVariable Long id){
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
