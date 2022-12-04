/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.documento;
import com.mycompany.proyecto.enums.TipoVehiculo;
import com.mycompany.proyecto.persona.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 *
 * @author LENOVO
 */
public class Orden {
    private Cliente cliente;
    private GregorianCalendar fecha;
    private String placaVehiculo;
    private TipoVehiculo tipoVehiculo;
    private ArrayList<Servicio> servicios;
    private ArrayList<Integer> cantidad;

    public Orden(Cliente cliente, GregorianCalendar fecha, String placaVehiculo, TipoVehiculo tipoVehiculo, ArrayList<Servicio> servicios) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.servicios = servicios;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    
}
