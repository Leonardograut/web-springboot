package com.projeto.web.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Pedido  implements Serializable{
    private static final long serialVersionUID=1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Instant momento; 
    


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




    public Pedido(Long id, Instant momento, Usuario client) {
        
        this.id = id;
        this.momento = momento;
        this.client = client;
    }




    public Pedido(){

    }

    
}
