package com.mycompany.proyectog1;

import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javafx.scene.control.Label;
import modelo.*;

/**
 * JavaFX App
 */
public class App extends Application {

    public static String pathPersonas="files/personas.csv";
    public static String pathUsuarios="files/usuarios.ser";
    public static String pathClientes="files/clientes.ser";
    public static String pathProveedores="files/proveedores.ser";
    public static String pathServicios="files/servicios.ser";
    public static String pathOrdenes="files/ordenes.ser";
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //crearArchivos(); METODO CREADO PARA CARGAR LAS LISTAS DEL ANTERIOR PROYECTO A ARCHIVOS SER
        scene = new Scene(loadFXML("primary"), 640, 480);
        
        stage.setScene(scene);
        stage.setTitle("Sistema de Información - Tecnicentro RP S.A.");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    //metodo para cambiar el contenido de la escena
    public static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }
    
   /* public void crearArchivos(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Servicio> servicios = new ArrayList<>();
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<Orden> ordenes = new ArrayList<>(); 
   //public static final String correo = "reportes@gmail.com";
   
    

     
   
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
    ArrayList<Orden> ord1 = new ArrayList<>(); //Las ordenes son de noviembre
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
    //Serializamos para tener los archivos serializados
    //ARCHIVOS USUARIOS
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathUsuarios))){
        out.writeObject(usuarios);
        out.flush();
    }catch (IOException ex){
        System.out.println("ERROR EN CREACION LISTA USUARIOS\n"
        +ex.getMessage());
    }
    //ARCHIVO PROVEEDORES
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathProveedores))){
        out.writeObject(proveedores);
        out.flush();
    }catch (IOException ex){
        System.out.println("ERROR EN CREACION LISTA PROVEEDORES\n"
        +ex.getMessage());
    }
    //ARCHIVO CLIENTES
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathClientes))){
        out.writeObject(clientes);
        out.flush();
    }catch (IOException ex){
        System.out.println("ERROR EN CREACION LISTA CLIENTES\n"
        +ex.getMessage());
    }
    //ARCHIVO ORDENES
     try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathOrdenes))){
        out.writeObject(ordenes);
        out.flush();
    }catch (IOException ex){
        System.out.println("ERROR EN CREACION LISTA ORDENES\n"
        +ex.getMessage());
    }
    //ARCHIVO SERVICIOS
     try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathServicios))){
        out.writeObject(servicios);
        out.flush();
    }catch (IOException ex){
        System.out.println("ERROR EN CREACION LISTA SERVICIOS\n"
        +ex.getMessage());
    }
    
    }*/
//aqui termina crear
   
    
    
    
}