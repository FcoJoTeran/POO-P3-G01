/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.persona;

import com.mycompany.proyecto.NewMain;
import com.mycompany.proyecto.documento.Orden;
import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
public class Servicio {
    private String codigo;
    private String nombre;
    private double precio;

    public Servicio(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
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
    
    public static double TotalServicio(Servicio s,int mes2, int agno2){
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
    }
}
