/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import com.mycompany.proyecto.enums.TipoCliente;
import java.util.ArrayList;
import com.mycompany.proyecto.persona.*;

import com.mycompany.proyecto.modelo.Usuario;
import com.mycompany.proyecto.usuario.*;
import com.mycompany.proyecto.enums.TipoUsuario;


/**
 *
 * @author LENOVO
 */
public class NewMain {

    /**
     */
    

   public static ArrayList<Usuario> usuarios = new ArrayList<>();
   public static ArrayList<Cliente> clientes = new ArrayList<>();
   public static ArrayList<Servicio> servicios = new ArrayList<>();
   public static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
   
   public void inicioSesion(){
       
       
   }
   
    public void inicializarSistema(){
    
    //Agregamos usuarios
    usuarios.add(new Admin("admin1","12345678","Administrador",TipoUsuario.ADMIN));
    usuarios.add(new Tecnico("alopez","al123456","Alvaro Lopez",TipoUsuario.TECNICO));
    usuarios.add(new Cobranza("mcastro","mc123456","Maria Castro",TipoUsuario.COBRANZAS));
    usuarios.add(new Tecnico("mbarcos","mb123456","Maria Barcos",TipoUsuario.TECNICO));
    //Agregamos clientes
    clientes.add(new Cliente("1", "cl1", "gye", "5931", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("2", "cl2", "uio", "5932", TipoCliente.PERSONAL));
    clientes.add(new Cliente("3", "cl3", "cue", "5933", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("4", "cl4", "gye", "5934", TipoCliente.PERSONAL));
}

    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("");
       
       
        //Admin c1 = (Admin)usuarios.get(0);
        //Admin.menu();
                
        
    }
    
    
}
