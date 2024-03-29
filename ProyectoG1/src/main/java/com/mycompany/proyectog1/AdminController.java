/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
*/
package com.mycompany.proyectog1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import modelo.Admin;
import modelo.Proveedor;
import modelo.Servicio;
import modelo.TipoCliente;

/**
 * FXML Controller class
 *
 * @author Ef
 */
public class AdminController implements Initializable {
        @FXML
    private VBox Titulo;

    
    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnServicio;

    @FXML
    private VBox datosAñadir;

    @FXML
    private Label nombreMenu;

    @FXML
    private Label nombreTabla;
    @FXML
    private FlowPane menu_edits;
    @FXML
    private VBox datos;
    
    
    public TextField en_telefono;
    public TextField en_dirección;
    public TextField en_cedula;
    public TextField en_nombre;
    public HBox cajGuardar;
    public static ArrayList<Cliente>  l_cliente = Admin.cargarCliente();
    public static ArrayList<Cliente> l_mostrar_cliente;
    public static ArrayList<Proveedor>  l_proveedor = Admin.cargarProveedor();
    public static ArrayList<Proveedor> l_mostrar_proveedor;
    public static ArrayList<Servicio> l_mostrar_servicio;
    public static ArrayList<Servicio>  l_servicio = Admin.cargarServicio();


    @FXML
    private TableView tabla_datos;
      @FXML
    private Label lblmenu;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datos.setVisible(false);
        menu_edits.setVisible(false);

        // TODO
    }

    public void btnClientes(){
        
        datos.setVisible(true);
        menu_edits.setVisible(true);



        nombreTabla.setText("Cliente");
        nombreMenu.setText("cliente");

        datosAñadir.getChildren().clear();
        Label cedula = new Label("Cedula");
        cedula.setPrefSize(120, 30);

         en_cedula = new TextField();
        en_cedula.setPrefSize(100, 30);
        en_cedula.setPromptText("digite cedula del cliente");

        Label nombre = new Label("Nombre");
        nombre.setPrefSize(120, 30);

        en_nombre = new TextField();
        en_nombre.setPrefSize(100, 30);
        en_nombre.setPromptText("digite  el nombre");

        Label direccion = new Label("Direccion: ");
        direccion.setPrefSize(120, 30);
        en_dirección = new TextField();
        en_dirección.setPrefSize(100, 30);
        en_dirección.setPromptText("digite  el direccion");


        Label telefono = new Label("Telefono ");
        telefono.setPrefSize(120, 30);
        en_telefono = new TextField();
        en_telefono.setPrefSize(100, 30);
        en_telefono.setPromptText("digite  el direccion");


        Label tipo = new Label("Tipo Cliente");
        HBox b = new HBox();

        tipo.setPrefSize(120, 30);
        RadioButton en_empresarial = new RadioButton();
        Label em = new Label("Empresarial");
        RadioButton en_personal = new RadioButton();
        Label per = new Label("Personal");

        ToggleGroup tg = new ToggleGroup();
        en_personal.setToggleGroup(tg);
        en_empresarial.setToggleGroup(tg);

        b.getChildren().addAll(en_empresarial,em,en_personal,per);


        b.setMargin(en_personal, new Insets(5,5,5,5));
        b.setMargin(en_empresarial, new Insets(5,5,5,5));

        datosAñadir.getChildren().addAll(cedula, en_cedula,nombre,en_nombre, direccion, en_dirección,telefono,en_telefono,tipo,b);
        datosAñadir.setMargin(cedula, new Insets(0, 0, 5,0));
        datosAñadir.setMargin(nombre, new Insets(5, 0, 5, 0));
        datosAñadir.setMargin(direccion, new Insets(5, 0, 5, 0));
        datosAñadir.setMargin(telefono, new Insets(5, 0, 5, 0));
        cargarTabla_cliente();
        cajGuardar = new HBox();
        
        datosAñadir.getChildren().addAll(cajGuardar);
        
        btnAgregar.setOnMouseClicked(eh->{
            lblmenu.setText("Agrgar Dato");
            cajGuardar.getChildren().clear();
            String cedula_1 = en_cedula.getText()+"";
        String direccion_1 = en_dirección.getText()+"";
        String  nombre_1 = en_nombre.getText()+"";
        String telefono_1 = en_telefono.getText()+"";
         TipoCliente tipo_cl = null;
        if(en_personal.isSelected()){
            tipo_cl = TipoCliente.PERSONAL;
        }
        else if(en_empresarial.isSelected()){
            tipo_cl = TipoCliente.EMPRESARIAL;
        }
        
            try{
            Cliente cl = new Cliente(cedula_1,Admin.generar_C_cliente(),nombre_1,direccion_1,telefono_1,tipo_cl);
            l_cliente.add(cl);
            cargarTabla_cliente();
            }
            catch(IOException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("faltan datos");
                alert.setHeaderText("faltan datos");
                alert.setContentText("faltan datos");
                alert.showAndWait();
            }
            en_empresarial.setSelected(false);
            en_personal.setSelected(false);
            en_cedula.setText("");
            en_dirección.setText("");
            en_nombre.setText("");
            en_telefono.setText("");
        });
        
        
        
        btnEditar.setOnMouseClicked(eh->{
            lblmenu.setText("Editar Dato");
        //String cedula_1 = en_cedula.getText()+"";
        //String direccion_1 = en_dirección.getText()+"";
        //String  nombre_1 = en_nombre.getText()+"";
        //String telefono_1 = en_telefono.getText()+"";
       
       cajGuardar.getChildren().clear();
       
       Button btnguarda = new Button("Guardar");
       
       cajGuardar.getChildren().add(btnguarda);
       
       /*
       cajGuardar.getChildren().add(btnguarda);
       cajGuardar.setAlignment(Pos.CENTER);
       cajGuardar.setMargin(btnguarda, new Insets(0, 0, 5,0));
       datosAñadir.getChildren().add(cajGuardar);
       
        */
        
        Cliente cl = (Cliente) tabla_datos.getSelectionModel().getSelectedItem();
        
        if(cl.getTipoCliente_1().equals(TipoCliente.PERSONAL)){
            en_personal.setSelected(true);
        }
        else if(cl.getTipoCliente_1().equals(TipoCliente.EMPRESARIAL)){
            en_empresarial.setSelected(true);
        }
        en_cedula.setText(cl.getCedula()+"");
        
        
        en_dirección.setText(cl.getDireccion()+"");
        
        en_nombre.setText(cl.getNombre()+"");
       
        en_telefono.setText(cl.getTelefono()+"");
        
        
        btnguarda.setOnMouseClicked(ev->{
        cl.setCedula(en_cedula.getText());
        cl.setDireccion(en_dirección.getText());
        cl.setNombre(en_nombre.getText());
        cl.setTelefono(en_telefono.getText());
        cargarTabla_cliente();
        en_cedula.setText("");
        
        
        en_dirección.setText("");
        
        en_nombre.setText("");
       
        en_telefono.setText("");
        
        en_empresarial.setSelected(false);
        en_personal.setSelected(false);
        });
            
        
        });
        
        btnEliminar.setOnMouseClicked(eh->{
        //datosAñadir.setVisible(false);
        //menu_edits.setVisible(true);
        lblmenu.setText("Dato borrado exitosamente");
        Cliente cl = (Cliente) tabla_datos.getSelectionModel().getSelectedItem();
        cl.setMostrar(false);
        cargarTabla_cliente();
        
        
        });
        
        
        
        

        

        ObjectInputStream in=null;
        //TableColumn<String> colum_1 = new TableColumn<>();

}
    
    @FXML
    void volvermenu(ActionEvent event) throws IOException{
        App.setRoot("vista_login");
        

    }
    @FXML
    public void btnProveedor(ActionEvent event) {
        tabla_datos.getColumns().clear();
        datos.setVisible(true);
        menu_edits.setVisible(true);



        nombreTabla.setText("Proveedor");
        nombreMenu.setText("Proveedor");

        datosAñadir.getChildren().clear();
        Label cedula = new Label("Cedula");
        cedula.setPrefSize(120, 30);

         en_cedula = new TextField();
        en_cedula.setPrefSize(100, 30);
        en_cedula.setPromptText("digite cedula del cliente");

        Label nombre = new Label("Nombre");
        nombre.setPrefSize(120, 30);

        en_nombre = new TextField();
        en_nombre.setPrefSize(100, 30);
        en_nombre.setPromptText("digite  el nombre");

        Label direccion = new Label("Direccion: ");
        direccion.setPrefSize(120, 30);
        en_dirección = new TextField();
        en_dirección.setPrefSize(100, 30);
        en_dirección.setPromptText("digite  el direccion");


        Label telefono = new Label("Telefono ");
        telefono.setPrefSize(120, 30);
        en_telefono = new TextField();
        en_telefono.setPrefSize(100, 30);
        en_telefono.setPromptText("digite  el direccion");

        datosAñadir.getChildren().addAll(cedula, en_cedula,nombre,en_nombre, direccion, en_dirección,telefono,en_telefono);
        datosAñadir.setMargin(cedula, new Insets(0, 0, 5,0));
        datosAñadir.setMargin(nombre, new Insets(5, 0, 5, 0));
        datosAñadir.setMargin(direccion, new Insets(5, 0, 5, 0));
        datosAñadir.setMargin(telefono, new Insets(5, 0, 5, 0));
        cargarTabla_proveedor();
        cajGuardar = new HBox();
        
        datosAñadir.getChildren().addAll(cajGuardar);
        
        btnAgregar.setOnMouseClicked(eh->{
            lblmenu.setText("Agrgar Dato");
            cajGuardar.getChildren().clear();
        String cedula_1 = en_cedula.getText()+"";
        String direccion_1 = en_dirección.getText()+"";
        String  nombre_1 = en_nombre.getText()+"";
        String telefono_1 = en_telefono.getText()+"";
                 
            try{
            Proveedor pr = new Proveedor(cedula_1,nombre_1,direccion_1,telefono_1);
            l_proveedor.add(pr);
            cargarTabla_proveedor();
            }
            catch(IOException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("faltan datos");
                alert.setHeaderText("faltan datos");
                alert.setContentText("faltan datos");
                alert.showAndWait();
            }
            en_cedula.setText("");
            en_dirección.setText("");
            en_nombre.setText("");
            en_telefono.setText("");
        });
        
        btnEditar.setOnMouseClicked(eh->{
            lblmenu.setText("Editar Dato");
        
       
       cajGuardar.getChildren().clear();
       
       Button btnguarda_pr = new Button("Guardar_pr");
       
       cajGuardar.getChildren().add(btnguarda_pr);
       

            Proveedor cl = (Proveedor) tabla_datos.getSelectionModel().getSelectedItem();

        en_cedula.setText(cl.getCodigo()+"");
        
        
        en_dirección.setText(cl.getDireccion()+"");
        
        en_nombre.setText(cl.getNombre()+"");
       
        en_telefono.setText(cl.getTelefono()+"");
        
        
        btnguarda_pr.setOnMouseClicked(ev->{
            
        cl.setCodigo(en_cedula.getText());
        cl.setDireccion(en_dirección.getText());
        cl.setNombre(en_nombre.getText());
        cl.setTelefono(en_telefono.getText());
        cargarTabla_proveedor();
        en_cedula.setText("");
        
        
        en_dirección.setText("");
        
        en_nombre.setText("");
       
        en_telefono.setText("");

        });
            
        
        });
        
        btnEliminar.setOnMouseClicked(eh->{
        //datosAñadir.setVisible(false);
        menu_edits.setVisible(true);
        lblmenu.setText("Dato borrado exitosamente");
        Proveedor cl = (Proveedor) tabla_datos.getSelectionModel().getSelectedItem();
        cl.setMostrar(false);
        cargarTabla_proveedor();
        
        });
        

    }
    
    
    public void cargarTabla_cliente() {
        tabla_datos.getColumns().clear();
        String [] arr_cliente =  Cliente.valores().split(",");
        int tamaño= arr_cliente.length;
        l_mostrar_cliente = new  ArrayList<>();
        System.out.println(l_cliente);
        
        /*
        try{
        Cliente cl = new Cliente("sdad", "dfsf", "asd", "uio", "dfsf", TipoCliente.PERSONAL);
        cl.setMostrar(false);
        l_cliente.add(cl);
        
        }
        catch(IOException e){
        }
        
*/
        for(Cliente e:l_cliente){
        if(e.isMostrar()){
        l_mostrar_cliente.add(e);
        }
        }
        for(int i = 0; i<tamaño;){
        String valor = arr_cliente[i]+"";
            //System.out.println(""+i);
            //System.out.println(valor);
        TableColumn<Cliente,String> t = new TableColumn<Cliente,String>(valor);
        
        t.setCellValueFactory(new PropertyValueFactory<>(valor));
        tabla_datos.getColumns().add(t);
        i++;
        
        }
         tabla_datos.getItems().setAll(l_mostrar_cliente);
         
        }
    public void cargarTabla_proveedor() {
        tabla_datos.getColumns().clear();
        String [] arr_cliente =  Proveedor.valores().split(",");
        int tamaño= arr_cliente.length;
        l_mostrar_proveedor = new  ArrayList<>();
        System.out.println(l_proveedor);

        for(Proveedor a:l_proveedor){
        if(a.isMostrar()){
        l_mostrar_proveedor.add(a);
        }
        }
        for(int i = 0; i<tamaño;){
        String valor = arr_cliente[i]+"";
            System.err.println(valor);
            //System.out.println(""+i);
            //System.out.println(valor);
        TableColumn<Proveedor,String> t = new TableColumn<Proveedor,String>(valor);
        
        t.setCellValueFactory(new PropertyValueFactory<>(valor));
        tabla_datos.getColumns().add(t);
        i++;
        }
        tabla_datos.getItems().setAll(l_mostrar_proveedor);
        }
    
    
    
    
      @FXML
    public void btnServicio(ActionEvent event) {
        tabla_datos.getColumns().clear();
        datos.setVisible(true);
        menu_edits.setVisible(true);



        nombreTabla.setText("Servicio");
        nombreMenu.setText("Servicio");

        datosAñadir.getChildren().clear();
        
        Label nombre = new Label("Nombre");
        nombre.setPrefSize(120, 30);

        en_nombre = new TextField();
        en_nombre.setPrefSize(100, 30);
        en_nombre.setPromptText("digite  el nombre");

        Label direccion = new Label("Precio ");
        direccion.setPrefSize(120, 30);
        en_dirección = new TextField();
        en_dirección.setPrefSize(100, 30);
        en_dirección.setPromptText("digite  precio");
        
        datosAñadir.getChildren().addAll( nombre,en_nombre, direccion, en_dirección);
        
        datosAñadir.setMargin(nombre, new Insets(5, 0, 5, 0));
        datosAñadir.setMargin(direccion, new Insets(5, 0, 5, 0));
        
        cargarTabla_Servicio();
        cajGuardar = new HBox();
        
        datosAñadir.getChildren().addAll(cajGuardar);
        
        btnAgregar.setOnMouseClicked(eh->{
            lblmenu.setText("Agrgar Dato");
            cajGuardar.getChildren().clear();
        
        String direccion_1 = en_dirección.getText();
        String  nombre_1 = en_nombre.getText()+"";
        
                 
            try{
            double precio = Double.valueOf(direccion_1);
            Servicio sr = new Servicio(Admin.generar_C_servicio(),nombre_1, precio);
            l_servicio.add(sr);
            cargarTabla_Servicio();
            }
            catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("pon bien el numero");
                alert.setHeaderText("pon bien el numero");
                alert.setContentText("pon bien el numero");
                alert.showAndWait();
            }
            catch(IOException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("faltan datos");
                alert.setHeaderText("faltan datos");
                alert.setContentText("faltan datos");
                alert.showAndWait();
            }
            
            en_dirección.setText("");
            en_nombre.setText("");
            
            
        });
        
        btnEditar.setOnMouseClicked(eh->{
            lblmenu.setText("Editar Dato");
        
       
       cajGuardar.getChildren().clear();
       
       Button btnguarda_pr = new Button("Guardar_pr");
       
       cajGuardar.getChildren().add(btnguarda_pr);
       

            Servicio cl = (Servicio) tabla_datos.getSelectionModel().getSelectedItem();

        
        
        
        en_dirección.setText(cl.getPrecio()+"");
        
        en_nombre.setText(cl.getNombre()+"");
       
        
        
        
        btnguarda_pr.setOnMouseClicked(ev->{
        
        
        cl.setPrecio(Double.valueOf(en_dirección.getText()));
        cl.setNombre(en_nombre.getText());
       
        cargarTabla_Servicio();
        
        en_dirección.setText("");
        
        en_nombre.setText("");
       
        });
        
        
        


    });
        
        
        btnEliminar.setOnMouseClicked(eh->{
        //datosAñadir.setVisible(false);
        menu_edits.setVisible(true);
        lblmenu.setText("Dato borrado exitosamente");
            Servicio cl = (Servicio) tabla_datos.getSelectionModel().getSelectedItem();
        cl.setMostrar(false);
        cargarTabla_Servicio();
        
        });
    }
    public void cargarTabla_Servicio() {
        tabla_datos.getColumns().clear();
        String [] arr_cliente =  Servicio.valores().split(",");
        int tamaño= arr_cliente.length;
        l_mostrar_servicio = new  ArrayList<>();
        System.out.println(l_servicio);

        for(Servicio s:l_servicio){
        if(s.isMostrar()){
        l_mostrar_servicio.add(s);
        }
        }
        for(int i = 0; i<tamaño;){
        String valor = arr_cliente[i]+"";
            System.err.println(valor);
            //System.out.println(""+i);
            //System.out.println(valor);
        TableColumn<Servicio,String> t = new TableColumn<Servicio,String>(valor);
        
        t.setCellValueFactory(new PropertyValueFactory<>(valor));
        tabla_datos.getColumns().add(t);
        i++;
        }
        tabla_datos.getItems().setAll(l_mostrar_servicio);
        }
    
     
        
        
    
    
    }






       
        
        
        

        
       

    
   
            
    
