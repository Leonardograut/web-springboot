package com.projeto.web.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.web.model.enums.PedidoStatus;






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
    
    
    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem>items = new HashSet<>();


    
   @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
   private Pagamento pagamento;

    
   
   
   
   
   
   
   
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




    


    public Pagamento getPagamento() {
        return pagamento;
    }




    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }




    public Usuario getClient() {
        return client;
    }




    public void setClient(Usuario client) {
        this.client = client;
    }



  public  Set<PedidoItem>getItems(){
    return items;
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
