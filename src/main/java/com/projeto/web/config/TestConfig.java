package com.projeto.web.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.web.model.Categoria;
import com.projeto.web.model.Pedido;
import com.projeto.web.model.Usuario;
import com.projeto.web.model.enums.PedidoStatus;
import com.projeto.web.repository.CategoriaRepository;
import com.projeto.web.repository.PedidoRepository;
import com.projeto.web.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;

   @Autowired
   private CategoriaRepository categoriaRepository;
   
    @Override
    public void run(String... args) throws Exception {
        
        Categoria cat1 = new Categoria(null, "Electronics"); 
        Categoria cat2 = new Categoria(null, "Books"); 
        Categoria cat3 = new Categoria(null, "Computers"); 
        
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));


        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");  


        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAID, u1); 
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.WAIITING_PAYMENT, u2); 
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.WAIITING_PAYMENT, u1); 
  
        


       
        usuarioRepository.saveAll(Arrays.asList(u1,u2));
        pedidoRepository.saveAll(Arrays.asList(o1,o2,o3)); 
    }





}
