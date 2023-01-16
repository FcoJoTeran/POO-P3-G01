/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
//import com.mycompany.proyecto.NewMain;
//import com.mycompany.proyecto.modelo.Persona;
import java.util.Objects;



//import com.mycompany.proyecto.modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */

public class Cliente extends Persona{
    TipoCliente tipoCliente_1;
    boolean mostrar;
    String cedula;

    public Cliente(String cedula_1, String codigo, String nombre, String direccion, String telefono, TipoCliente tipoCliente) {
        super(codigo,nombre,direccion,telefono);
        tipoCliente_1 = tipoCliente;
        mostrar = true;
        cedula =cedula_1;
    }   
        
    public String toString(Cliente e){
    Persona ob = (Persona)e;
    String msg = e.toString() + ", "+ tipoCliente_1;
    return msg;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public TipoCliente getTipoCliente_1() {
        return tipoCliente_1;
    }

   

    public boolean isMostrar() {
        return mostrar;
    }

    public String getCedula() {
        return cedula;
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
    
 
    /*public static Cliente BuscarCliente(String cod){
        for(Cliente c: NewMain.clientes){
            
            if(Objects.equals(cod,c.getCodigo()))
                return c;
        }
        return null;
    }*/
    @Override
    public String toString(){
        return nombre;
    }
    
    
}

