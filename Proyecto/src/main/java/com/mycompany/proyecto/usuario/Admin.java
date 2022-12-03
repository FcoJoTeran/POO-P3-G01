/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.usuario;
import com.mycompany.proyecto.modelo.Usuario;
import com.mycompany.proyecto.persona.*;
import com.mycompany.proyecto.enums.TipoCliente;
import com.mycompany.proyecto.enums.TipoUsuario;
import java.util.Scanner;
import com.mycompany.proyecto.NewMain;


/**
 *
 * @author LENOVO
 */
public class Admin extends Usuario{
     
    
    public Admin(String usuario, String contraseña, String nombre, TipoUsuario TipoUsuario) {
        super(usuario, contraseña, nombre, TipoUsuario);
    }
    
    public static void menu () {
     
        System.out.println("1 Administrar Clientes\n" + "2. Administrar Proveedores\n" + "3. Administrar servicios\n");
        int var;
        Scanner sc = new Scanner(System.in);
        System.out.println("Eliga opcion: " );
        
        
        var = sc.nextInt();
        
        
        while (var != 0 ){
        
        switch (var) {
            
            case 1:
                int a = 1;
                
                while(a == 1){
                    a = Agregar_cliente();
                }
              
                break;
                
            case 2:
                
            case 3:
                
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
                System.out.println("Codigo del cliente: "  );
                String codigo = sc1.next();
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
    
    
    
    
    
    
    
    
    
    
}
