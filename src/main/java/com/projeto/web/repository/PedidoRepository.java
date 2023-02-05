package com.projeto.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.web.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido,Long>{
   
    
}
