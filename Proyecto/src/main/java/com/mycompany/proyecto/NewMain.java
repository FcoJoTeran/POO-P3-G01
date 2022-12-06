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
import com.mycompany.proyecto.enums.TipoVehiculo;
import com.mycompany.proyecto.usuario.Admin;
import java.util.GregorianCalendar;
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
   public static ArrayList<Orden> ordenes = new ArrayList<>(); 
   public static final String correo = "reportes@gmail.com";
   
    public static void inicializarSistema(){

     
   
    //Agregamos clientes
    clientes.add(new Cliente("1", "Carlos", "gye", "5931", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("2", "Maria", "uio", "5932", TipoCliente.PERSONAL));
    clientes.add(new Cliente("3", "Esteban", "cue", "5933", TipoCliente.EMPRESARIAL));
    clientes.add(new Cliente("4", "Erick", "gye", "5934", TipoCliente.PERSONAL));
    //Agregamos servicios
    servicios.add(new Servicio("1","Cambio de filtro",120));
    servicios.add(new Servicio("2","Cambio de pastillas de freno",230));
    servicios.add(new Servicio("3","Cambio de amortiguadores",120));
    servicios.add(new Servicio("4","Cambio de embragues",145));
    servicios.add(new Servicio("5","Cambio de filtro",120));
    servicios.add(new Servicio("6","Cambio de filtro",120));
    //Agregamos proveedores 
    proveedores.add(new Proveedor("1", "Justin", "Quito", "5935"));
    proveedores.add(new Proveedor("2", "Francisco", "Machala", "5936"));
    //Creamos los ArrayList para los servicios que van en cada orden de cada tecnico con su respectiva cantidad
     ArrayList<Servicio> serv1 = new ArrayList<>();
     serv1.add(servicios.get(0));
     serv1.add(servicios.get(1));
     ArrayList<Integer> cant1 = new ArrayList<>();
     cant1.add(3);
     cant1.add(4);
     ArrayList<Servicio> serv2 = new ArrayList<>();
     serv2.add(servicios.get(2));
     serv2.add(servicios.get(3));
     ArrayList<Integer> cant2 = new ArrayList<>();
     cant2.add(2);
     cant2.add(1);
     ArrayList<Servicio> serv3 = new ArrayList<>();
     serv3.add(servicios.get(4));
     serv3.add(servicios.get(5));
     ArrayList<Integer> cant3 = new ArrayList<>();
     cant3.add(1);
     cant3.add(2);
     ArrayList<Servicio> serv4 = new ArrayList<>();
     serv4.add(servicios.get(0));
     serv4.add(servicios.get(5));
     ArrayList<Integer> cant4 = new ArrayList<>();
     cant4.add(2);
     cant4.add(3);
    //Creamos dos ArrayList para las ordenes para cada tecnico
    ArrayList<Orden> ord1 = new ArrayList<>();
    ord1.add(new Orden(clientes.get(0),new GregorianCalendar(2020,10,2),"GSE-1082",TipoVehiculo.BUS,serv1,cant1));
    ord1.add(new Orden(clientes.get(1),new GregorianCalendar(2020,10,4),"GFH-6743",TipoVehiculo.AUTOMOVIL,serv2,cant2));
    ArrayList<Orden> ord2 = new ArrayList<>();
    ord2.add(new Orden(clientes.get(0),new GregorianCalendar(2020,10,5),"GHJ-6653",TipoVehiculo.MOTOCICLETAS,serv1,cant3));
    ord2.add(new Orden(clientes.get(0),new GregorianCalendar(2020,10,6),"GKI-1432",TipoVehiculo.BUS,serv1,cant4));
    //Unimos todas las listas de ordenes en una sola
    ordenes.addAll(ord1);
    ordenes.addAll(ord2);
     //Agregamos usuarios
    usuarios.add(new Admin("admin1","12345678","Administrador",TipoUsuario.ADMIN));
    usuarios.add(new Tecnico("alopez","al123456","Alvaro Lopez",TipoUsuario.TECNICO,ord1));
    usuarios.add(new Cobranza("mcastro","mc123456","Maria Castro",TipoUsuario.COBRANZAS));
    usuarios.add(new Tecnico("mbarcos","mb123456","Maria Barcos",TipoUsuario.TECNICO,ord2));
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
                case ADMIN -> {
                    Admin ad =(Admin)consulta(inicioUser);
                    ad.menu();
                }
                case TECNICO -> {
                }
                case COBRANZAS -> {
                    Cobranza cd = (Cobranza)consulta(inicioUser);
                    cd.menu();
                }
                default -> {
                }
                    
            }
            //Tecnico tecnico;
            //tecnico.menu();
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
    

