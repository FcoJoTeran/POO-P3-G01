/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.documento;
import com.mycompany.proyecto.enums.TipoVehiculo;
import com.mycompany.proyecto.persona.*;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class Orden {
    public Cliente cliente;
    public String fecha;
    public String placaVehiculo;
    public TipoVehiculo tipoVehiculo;
    public ArrayList<Servicio> servicios;
}
