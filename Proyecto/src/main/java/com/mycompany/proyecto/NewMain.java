/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import com.mycompany.proyecto.documento.Orden;
import com.mycompany.proyecto.enums.TipoCliente;
import java.util.ArrayList;
import com.mycompany.proyecto.persona.*;

import com.mycompany.proyecto.modelo.Usuario;
import com.mycompany.proyecto.usuario.*;
import com.mycompany.proyecto.enums.TipoUsuario;
import static com.mycompany.proyecto.usuario.Admin.menu;
import java.util.Scanner;


/**
 *
 * @author LENOVO
 */
public class NewMain {

    /**
     */
   public static  Scanner sc = new Scanner(System.in);

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
    clientes.add(new Cliente("1cgd", "Carlos", "gye", "5931", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("2ghd", "Maria", "uio", "5932", TipoCliente.PERSONAL));
    clientes.add(new Cliente("3hjk", "Esteban", "cue", "5933", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("4jkl", "Erick", "gye", "5934", TipoCliente.PERSONAL));
    //Agregamos servicios
    servicios.add(new Servicio("CF1","Cambio de filtro",120));
    servicios.add(new Servicio("CPF","Cambio de pastillas de freno",230));
    servicios.add(new Servicio("CAD","Cambio de amortiguadores",120));
    servicios.add(new Servicio("CF1","Cambio de embragues",145));
    servicios.add(new Servicio("CF1","Cambio de filtro",120));
    servicios.add(new Servicio("CF1","Cambio de filtro",120));
    //Agregamos proveedores 
    proveedores.add(new Proveedor("prov1", "Justin", "Quito", "5935"));
    proveedores.add(new Proveedor("prov2", "Francisco", "Machala", "5936"));
    //Creamos dos ArrayList para las ordenes para cada tecnico
    ArrayList<Orden> ord1 = new ArrayList<>();
    //ord1.add(new Orden(clientes.get(0),));
    ArrayList<Orden> ord2 = new ArrayList<>();
}
    public static Usuario consulta(Usuario u){
        for(Usuario a: usuarios){
      if(a.equals(u)){
            return a;
        } 
    }return null;
}
    
    public static void iniciarSesion(){
         
        System.out.println("");
        
        System.out.println("Inicio de sesión: ");
        System.out.print("Ingrese su usuario: ");
        String user = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String passw = sc.nextLine();
        
        Usuario inicioUser = new Admin(user,passw,"",TipoUsuario.ADMIN);
        
          if(consulta(inicioUser)!= null){
            TipoUsuario tipo= consulta(inicioUser).getTipoUsuario();
            switch(tipo){
                case ADMIN:
                menu();
                break;
                case TECNICO:
                    System.out.println("tech");
                    break;
                case COBRANZAS:
                    System.out.println("cobr");
                    break;
                default:
                    
            }
        }else{
            System.out.println("Usuario o contraseña incorrecta");
            iniciarSesion();
            
        }
         
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        inicializarSistema();
        iniciarSesion();
      
        
        
        //
    
       Admin c1 = (Admin)usuarios.get(0);
        //Admin.menu();
                
        sc.close();
    }
     }
    

