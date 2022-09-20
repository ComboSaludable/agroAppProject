package com.cdp.Agro.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {


    private int id;
    private String nombre;
    private String categoria;
    private String precio;
    private String descripcion;
    private String stock;
    private String disponibilidad;



}
