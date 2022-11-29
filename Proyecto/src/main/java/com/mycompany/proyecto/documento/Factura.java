/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.documento;

import com.mycompany.proyecto.persona.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Factura {
    public Cliente cliente;    //Es un cliente de tipo empresarial
    public int agno;
    public int mes;
    public ArrayList<Orden> ordenes;
    
}
