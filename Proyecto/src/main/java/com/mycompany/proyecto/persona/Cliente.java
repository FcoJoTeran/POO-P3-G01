/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.persona;
import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.enums.TipoUsuario;
import com.mycompany.proyecto.modelo.Persona;



import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */

public class Cliente extends Persona{
    TipoCliente tipoCliente_1;

    public Cliente(String codigo, String nombre, String direccion, String telefono, TipoCliente tipoCliente) {
        super(codigo,nombre,direccion,telefono);
        tipoCliente_1 = tipoCliente;
    }   
        
    public String toString(Cliente e){
    Persona ob = (Persona)e;
    String msg = e.toString() + ", "+ tipoCliente_1;
    return msg;
    }

    public TipoCliente getTipoCliente_1() {
        return tipoCliente_1;
    }
    
}

