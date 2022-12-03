/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.usuario;

import com.mycompany.proyecto.enums.TipoUsuario;
import com.mycompany.proyecto.modelo.Usuario;

/**
 *
 * @author LENOVO
 */
public class Admin extends Usuario {

    public Admin(String u, String c, String n, TipoUsuario t) {
        super(u,c,n,t);
    }
    
    public void menu(){
        System.out.println("""
                           1. Administrar Clientes
                           2. Administrar Proveedores
                           3. Admnistrar Servicios
                           """);}
    
}
