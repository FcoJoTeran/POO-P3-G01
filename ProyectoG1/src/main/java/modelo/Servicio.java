/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import com.mycompany.proyecto.NewMain;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
public class Servicio implements Serializable{
    private String codigo;
    private String nombre;
    private double precio;
    boolean mostrar;
    //private static final long serialVersionUID = 1234567L;

    public Servicio(String codigo, String nombre, double precio) throws IOException{
        if(nombre.equals("")){
        throw new IOException(
        );
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        mostrar= true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
     public static String valores(){
        String mensaje = "codigo,nombre,precio";
    return mensaje;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }
     
    
    
    
   /* public static double TotalServicio(Servicio s,int mes2, int agno2){
        double total = 0;
    for(Orden o: NewMain.ordenes){
                    if(o.getFecha().get(Calendar.MONTH) == mes2 && (o.getFecha().get(Calendar.YEAR) == agno2 )){
                        for(Servicio ser: o.getServicios()){
                        if(ser.equals(s)){
                            int idx = o.getServicios().indexOf(ser);
                            total += (ser.getPrecio()* o.getCantidad().get(idx));
                        }
                        }
                    }
                }
    return total;
    }
    
    public static Servicio BuscarServicio(String servicio){
        for(Servicio s: NewMain.servicios){
            if(servicio.equals(s.getCodigo()))
                return s;
        }
        return null;
    }*/

    @Override
    public String toString() {
        return   "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio ;
    }
    
    
    
}
