/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.modelo;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public abstract class Persona {
    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Persona(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public  String toString() {
        String msg;
        msg = codigo + ", " + nombre +","+ direccion + ", " + telefono ;
        return msg;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
   
}

