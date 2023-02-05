package com.projeto.web.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.web.model.enums.PedidoStatus;
import com.projeto.web.service.PedidoService;





@Entity
public class Pedido  implements Serializable{
    private static final long serialVersionUID=1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     

    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyy-MM-dd'T'HH:mm:ss'Z'",timezone ="GMT")
    private Instant momento; 
    
   


    private Integer pedidostatus;

    public PedidoStatus getPedidostatus() {
        return PedidoStatus.valueOf(pedidostatus);
    }




    public void setPedidostatus(PedidoStatus pedidostatus) {
        if(pedidostatus != null){
            this.pedidostatus = pedidostatus.getCode();
        }
       
    }




    @ManyToOne
    @JoinColumn(name ="client_id")
    private Usuario  client;
    
    
    public Long getId() {
        return id;
    }




    public void setId(Long id) {
        this.id = id;
    }




    public Instant getMomento() {
        return momento;
    }




    public void setMomento(Instant momento) {
        this.momento = momento;
    }




    public Usuario getClient() {
        return client;
    }




    public void setClient(Usuario client) {
        this.client = client;
    }




    



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }




    public Pedido(Long id, Instant momento, PedidoStatus pedidostatus, Usuario client) {
        
        this.id = id;
        this.momento = momento;
        this.client = client;
        setPedidostatus(pedidostatus);
    }




    public Pedido(){

    }

    
}
