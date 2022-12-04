/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.usuario;

import com.mycompany.proyecto.documento.Orden;
import com.mycompany.proyecto.enums.TipoUsuario;
import com.mycompany.proyecto.modelo.Usuario;
import java.util.ArrayList;
import com.mycompany.proyecto.NewMain;
import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.persona.Cliente;
import com.mycompany.proyecto.persona.Servicio;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Tecnico extends Usuario{
    private ArrayList<Orden> listaOrden;
    public Tecnico(String u, String c, String n, TipoUsuario t, ArrayList<Orden> listaOrden) {
        super(u,c,n,t);
        this.listaOrden = listaOrden;
    }
    
   public double totalPorTecnico(int mes3, int agno3){
    double total = 0;
    for(Orden o: listaOrden){
                    if(o.getFecha().get(Calendar.MONTH) == mes3 && (o.getFecha().get(Calendar.YEAR) == agno3 )){
                        for(Servicio ser: o.getServicios()){
                            int idx = o.getServicios().indexOf(ser);
                            total += (ser.getPrecio()* o.getCantidad().get(idx));
                        
                    }
    }
   }
    return total;
}
}
