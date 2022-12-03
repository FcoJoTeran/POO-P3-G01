/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.util.ArrayList;
import com.mycompany.proyecto.modelo.*;
import com.mycompany.proyecto.persona.*;
import com.mycompany.proyecto.modelo.Usuario;
import com.mycompany.proyecto.usuario.*;
import com.mycompany.proyecto.persona.*;
import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.enums.TipoUsuario;
/**
 *
 * @author LENOVO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    
   public static ArrayList<Usuario> usuarios = new ArrayList<>();
   public static ArrayList<Cliente> clientes = new ArrayList<>();
   public static ArrayList<Servicio> servicios = new ArrayList<>();
   public static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
    public void iniciar(){
    
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("");
        Admin a = new Admin("admin1","12345678","Administrador",TipoUsuario.ADMIN);
        usuarios.add(a);
        Admin c1 = (Admin)usuarios.get(0);
        c1.menu();
        
        
        

    }
    
    
}
