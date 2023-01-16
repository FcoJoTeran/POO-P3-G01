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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cliente;
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
    private Button btnProveedor;

    @FXML
    private Button btnServicio;

    @FXML
    private VBox datosAñadir;

    @FXML
    private Label nombreMenu;

    @FXML
    private Label nombreTabla;
    
    
    @FXML
    private TableView<Cliente> tabla_datos;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }
    
    public void btnClientes(){
        
    
        
        nombreTabla.setText("Cliente");
        nombreMenu.setText("cliente");
        
        datosAñadir.getChildren().clear();
        Label cedula = new Label("Cedula");
        cedula.setPrefSize(120, 30);
        
        TextField en_cedula = new TextField();
        en_cedula.setPrefSize(100, 30);
        en_cedula.setPromptText("digite cedula del cliente");
        
        Label nombre = new Label("Nombre");
        nombre.setPrefSize(120, 30);
        
        TextField en_nombre = new TextField();
        en_nombre.setPrefSize(100, 30);
        en_nombre.setPromptText("digite  el nombre");
        
        Label direccion = new Label("Direccion: ");
        direccion.setPrefSize(120, 30);
        TextField en_dirección = new TextField();
        en_dirección.setPrefSize(100, 30);
        en_dirección.setPromptText("digite  el direccion");
        
        
        Label telefono = new Label("Telefono ");
        telefono.setPrefSize(120, 30);
        TextField en_telefono = new TextField();
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
        
        if(en_personal.isSelected()){
            TipoCliente l = TipoCliente.PERSONAL;
        }
        else{
            TipoCliente l = TipoCliente.EMPRESARIAL;
        }
        
        ObjectInputStream in=null;
        //TableColumn<String> colum_1 = new TableColumn<>();
        try {
            
            in = new ObjectInputStream(new FileInputStream(App.pathClientes));
            ArrayList<Cliente> s = (ArrayList<Cliente>) in.readObject();
            System.out.println(s );
            System.out.println(s.size());
            for(Cliente e: s){
                System.out.println(e.getNombre());
                System.out.println(e.getCodigo());
         
            }
            //TableColumn cedula = new TableColumn<Cliente,String>(cedula);
            in.close();
        } catch (FileNotFoundException ex) {
             System.err.println("No se encuentra archivo");
        } catch (IOException ex) {
           System.err.println("Error"+ex.getMessage());
        } catch (ClassNotFoundException ex) {
           System.err.println("Error"+ex.getMessage());
        }
        
        
           
        
        
        
        
   
} 

  

    
    
            
    
}
