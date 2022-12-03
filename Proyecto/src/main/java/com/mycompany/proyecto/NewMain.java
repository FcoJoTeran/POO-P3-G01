/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.util.ArrayList;
import com.mycompany.proyecto.persona.*;

import com.mycompany.proyecto.modelo.Usuario;
import com.mycompany.proyecto.usuario.*;
import com.mycompany.proyecto.enums.TipoUsuario;
import java.util.Scanner;


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
    
   
    public static void inicializarSistema(){
    
    //Agregamos usuarios
    usuarios.add(new Admin("admin1","12345678","Administrador",TipoUsuario.ADMIN));
    usuarios.add(new Tecnico("alopez","al123456","Alvaro Lopez",TipoUsuario.TECNICO));
    usuarios.add(new Cobranza("mcastro","mc123456","Maria Castro",TipoUsuario.COBRANZAS));
    usuarios.add(new Tecnico("mbarcos","mb123456","Maria Barcos",TipoUsuario.TECNICO));
    //Agregamos clientes
    //clientes.add(new Cliente(String codigo, String nombre, String direccion, String telefono, TipoCliente tipoCliente));
}

    public static void main(String[] args) {
        // TODO code application logic here
        inicializarSistema();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Inicio de sesión: ");
        System.out.print("Ingrese su usuario: ");
        String user = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String passw = sc.nextLine();
        
        Usuario inicioUser = new Admin(user,passw,"",TipoUsuario.ADMIN);
       
        if(usuarios.contains(inicioUser)){
            
        }
        //Admin c1 = (Admin)usuarios.get(0);
        Admin.menu();
                
        
    }
    
    
}
