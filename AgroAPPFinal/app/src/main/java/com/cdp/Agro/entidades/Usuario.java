package com.cdp.Agro.entidades;

import com.cdp.Agro.enums.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {


    private Persona persona;
    private String email;
    private String user;
    private String password;
    private Rol rol;

}
