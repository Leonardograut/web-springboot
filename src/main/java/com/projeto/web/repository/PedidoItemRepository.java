package com.projeto.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.web.model.PedidoItem;

public interface PedidoItemRepository  extends JpaRepository<PedidoItem,Long>{
    
}
