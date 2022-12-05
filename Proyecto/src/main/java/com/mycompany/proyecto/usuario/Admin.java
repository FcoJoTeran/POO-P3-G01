/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.usuario;
import com.mycompany.proyecto.persona.*;
import com.mycompany.proyecto.enums.TipoCliente;
import java.util.Scanner;
import com.mycompany.proyecto.NewMain;
import com.mycompany.proyecto.enums.TipoUsuario;
import com.mycompany.proyecto.modelo.Usuario;
import java.util.ArrayList;


public class Admin extends Usuario{
     
    
    public Admin(String usuario, String contraseña, String nombre, TipoUsuario TipoUsuario) {
        super(usuario, contraseña, nombre, TipoUsuario);
    }
    
    public void menu (){
     
        System.out.println("1 Administrar Clientes\n" + "2. Administrar Proveedores\n" + "3. Administrar servicios\n");
        int var;
        Scanner sc = new Scanner(System.in);
        System.out.println("Eliga opcion: " );
        
        
        var = sc.nextInt();
        
        
        while (var != 0 ){
        
        switch (var) {
            
            case 1:
                int a = 1;
                System.err.println("Lista de Cliente\n");
                
                 m_lista_Cliente();
                 
                while(a == 1){
                    
                   
                    a = Agregar_cliente();
                }
              
                break;
                
            case 2:
                int b = 1;
                
                
                while(b == 1){
                    System.err.println("Lista de Proveedores\n");
                    m_lista_proveedores();
                    b = Agregar_Provedor();
                }
                break;
                
            case 3:
                int c = 0;
                System.err.println("Lista de Servicios\n");
                
                while (c !=3) {
                m_lista_Servicio();
                //Scanner sc2 = new Scanner(System.in);
                  
                System.err.println("1.Agregar Servicios\n"+"2.Editar Servicio\n"+"3.Regresar");
                Scanner sc2= new Scanner(System.in);
                c = sc2.nextInt();
                if(c==1){
                 c = Agregar_servicio();
                
                }
                if(c==2){
                    c = Editar_servicio();
                }
                
                }
                break;
            default:
                throw new AssertionError();
        }
        System.out.println("1 Administrar Clientes\n" + "2. Administrar Proveedores\n" + "3. Administrar servicios\n");
        var = sc.nextInt();
        
        }
        sc.close();
               
    }
    public static int Agregar_cliente() {
        
        Scanner sc1= new Scanner(System.in);
     
        System.out.println("1 Agregar Cliente\n" + "2. regresar\n" );
                    int a = sc1.nextInt();
                    if(a != 2){
                
                System.out.println("Nombre del cliente: "  );
                String nombre = sc1.next();
                
                String codigo = generar_C_cliente();
                System.out.println("Direccion del cliente: "  );
                String direccion = sc1.next();
                System.out.println("Telefono del cliente: "  );
                String telefono = sc1.next();
                
                System.out.println("Eliga tipo de cliente 1 Empresarial o 2 Personal"  );
                int opc = sc1.nextInt();
                TipoCliente t;
                if(opc == 1){
                t = TipoCliente.EMPRESARIAL;
                }
                else{
                t = TipoCliente.PERSONAL;
                }
                
                Cliente cl = new Cliente(codigo,nombre,direccion,telefono,t);
                
                NewMain.clientes.add(cl);
                    
                    } 
     return a;
     
    }
    
    public static void m_lista_Cliente() {
        for(int ind =0 ; ind < NewMain.clientes.size(); ind++ ){
                Cliente cl_ind =  NewMain.clientes.get(ind);
                String msg = cl_ind.toString(cl_ind);
                    System.err.println(msg);
                                        }
        System.err.println("\n");
        
    }
    
    public static void m_lista_Servicio() {
        for(int ind =0 ; ind < NewMain.servicios.size(); ind++ ){
                Servicio sv_ind =  NewMain.servicios.get(ind);
                String msg = sv_ind.toString();
                    System.err.println(msg);
                                        }
        System.err.println("\n");
        
    }
    public static void m_lista_proveedores() {
        if(NewMain.proveedores.size() != 0){
        for(int ind =0 ; ind < NewMain.proveedores.size(); ind++ ){
                Proveedor cl_ind =  NewMain.proveedores.get(ind);
                String msg = cl_ind.toString();
                    System.err.println(msg);
                                        }
        System.err.println("\n");
        }
        else{
            System.err.println("Vacio");
        }
        
    }
    public static String generar_C_cliente() {
        
        
        Cliente u_cliente = NewMain.clientes.get(NewMain.clientes.size() - 1) ;
        String codigo = u_cliente.getCodigo();
        int u_c = Integer.valueOf(codigo)+1;
        String u_c1= u_c + "";
        
        return u_c1;
        
    }
    
    public static String generar_C_servicio() {
        
        
        Servicio u_cliente = NewMain.servicios.get(NewMain.servicios.size() - 1) ;
        String codigo = u_cliente.getCodigo();
        int u_c = Integer.valueOf(codigo)+1;
        String u_c1= u_c + "";
        
        return u_c1;
        
    }
    public static String generar_C_proveedor() {
        
        if( NewMain.proveedores.size() != 0){
        
        Proveedor u_cliente = NewMain.proveedores.get(NewMain.proveedores.size() - 1) ;
        
        String codigo = u_cliente.getCodigo();
        
        int u_c = Integer.valueOf(codigo)+1;
        String u_c1= u_c + "";
        return u_c1;
        }
        return "0";
        
        
        
    }
    
    
    
    
    public static int Agregar_Provedor() {
        
        Scanner sc1= new Scanner(System.in);
        System.out.println("1.Agraegar Proveedor\n" +"2.Regresar\n" );
                    int w = sc1.nextInt();
                    if(w != 2){
                
                System.out.println("Nombre del Proveedor: "  );
                String nombre = sc1.next();
                
                String codigo = generar_C_proveedor();
                System.out.println("Direccion del Proveedor: "  );
                String direccion = sc1.next();
                System.out.println("Telefono del Proveedor: "  );
                String telefono = sc1.next();
                         
                 Proveedor pl = new Proveedor(codigo,nombre,direccion,telefono);
                
                NewMain.proveedores.add(pl);
                    
                    } 
     return w;
     
    }
    
    public static int Agregar_servicio() {
        
        Scanner sc1= new Scanner(System.in);
     
        
                    
                    
                
                System.out.println("Nombre del Servicio: "  );
                String nombre = sc1.next();
                
                String codigo = generar_C_servicio();
                System.out.println("Precio "  );
                Double precio = sc1.nextDouble();
                         
                 Servicio sr = new Servicio(codigo,nombre,precio);
                
                NewMain.servicios.add(sr);
                    
                    
        System.err.println("1.Agregar Servicios\n"+"2.Editar Servicio\n"+"3.Regresar");
        int a = sc1.nextInt();
     return a;
     
    }
    
    
    
    public static int Editar_servicio() {
        
        
        
        Scanner sc1= new Scanner(System.in);
        System.out.println("Ingrese codigo "  );
         String codigo = sc1.next();
         
         
         for(int i = 0; i<NewMain.servicios.size();i++){
             if(codigo.equals(NewMain.servicios.get(i).getCodigo())){
                 System.err.println("ingrse Nuevo precio");
                 Double a = sc1.nextDouble();
                 NewMain.servicios.get(i).setPrecio(a);
         
         }
         }
        
        System.err.println("1.Agregar Servicios\n"+"2.Editar Servicio\n"+"3.Regresar");
        int a = sc1.nextInt();
     return a;   
    }
    
}


    
    
    
    
    
    
    
    
