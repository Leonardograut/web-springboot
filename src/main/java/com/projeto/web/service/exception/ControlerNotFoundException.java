package com.projeto.web.service.exception;

public class ControlerNotFoundException extends RuntimeException {

    private  static final long serialVersionUID =1L;


    public ControlerNotFoundException(Object id){

        super("Controller not fount .Id"+id);

        

    }
    
}
