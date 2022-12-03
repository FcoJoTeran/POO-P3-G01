/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import com.mycompany.proyecto.enums.TipoUsuario;
import java.util.ArrayList;
import com.mycompany.proyecto.modelo.*;
import com.mycompany.proyecto.persona.*;
import com.mycompany.proyecto.usuario.*;
/**
 *
 * @author LENOVO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    public void inicializarSistema(){
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Servicio> servicios = new ArrayList<>();
    ArrayList<Proveedor> proveedores = new ArrayList<>();
    //Agregamos usuarios
    usuarios.add(new Admin("admin1","12345678","Administrador",TipoUsuario.ADMIN));
    usuarios.add(new Tecnico("alopez","al123456","Alvaro Lopez",TipoUsuario.TECNICO));
    usuarios.add(new Cobranza("mcastro","mc123456","Maria Castro",TipoUsuario.COBRANZAS));
    usuarios.add(new Tecnico("mbarcos","mb123456","Maria Barcos",TipoUsuario.TECNICO));
    //Agregamos clientes
    clientes.add(new Cliente());
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("");
    }
    
}
