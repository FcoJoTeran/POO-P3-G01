/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.persona;

import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Cliente extends Persona {
    private TipoCliente tipo;

    public Cliente(String c, String n, String d, String t,TipoCliente tipo) {
        super(c,n,d,t);
        this.tipo = tipo;
    }

  
    
    
    }
    
   
        
    }

