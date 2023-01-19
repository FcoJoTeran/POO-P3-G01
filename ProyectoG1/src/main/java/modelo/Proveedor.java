/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author LENOVO
 */
public class Proveedor extends Persona{
    boolean mostrar;

    public Proveedor(String codigo, String nombre, String direccion, String telefono)throws IOException {
        super(codigo, nombre, direccion, telefono);
        if(codigo.equals("")||nombre.equals("")||direccion.equals("")||telefono.equals("")){
        throw new IOException(
        );
        }
        mostrar = true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "mostrar=" + mostrar + '}';
    }
    public static String valores(){
        String mensaje = "codigo,nombre,direccion,telefono";
    return mensaje;
    }
    public boolean isMostrar() {
        return mostrar;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
