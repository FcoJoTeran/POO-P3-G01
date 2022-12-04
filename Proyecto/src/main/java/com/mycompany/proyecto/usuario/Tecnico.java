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

/**
 *
 * @author LENOVO
 */
public class Tecnico extends Usuario{
    private ArrayList<Orden> listaOrden;
    public Tecnico(String u, String c, String n, TipoUsuario t) {
        super(u,c,n,t);
        this.listaOrden = listaOrden;
    }
    
}
