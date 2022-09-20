package com.cdp.Agro.entidades;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;
    private Long numeroPedido;
    private double valorPagar;
    private ArrayList productos = new ArrayList();
    private Date fechaRegistro;
    private Usuario comprador;
    private Usuario vendedor;


    private String metodoPagos;
    private String productos2;

}
