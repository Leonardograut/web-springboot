package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.web.model.Pedido;
import com.projeto.web.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
 
    @Autowired
    private  PedidoService service;


    @GetMapping
    public ResponseEntity<List<Pedido>>findAll(){
         List<Pedido> list = service.findAll();
         return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedido>findByid(@PathVariable Long id){
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }


}
