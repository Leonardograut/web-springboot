package com.projeto.web.model.enums;

public enum PedidoStatus {
    
    WAIITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private PedidoStatus(int code){
        this.code = code;
    }


    public int getCode(){
        return code;
    }

    public static PedidoStatus valueOf(int code){              //esse metodo vai retorna um objeto do tipo pedidostatus
       for(PedidoStatus value : PedidoStatus.values()){
          if(value.getCode() ==code){
            return value;
          }
       }
       throw new IllegalArgumentException("invalido PedidoStatus code");
    }
}
