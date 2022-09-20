package com.cdp.Agro.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {


    private int valor;
    private Usuario calificador;
    private Usuario calificado;

}
