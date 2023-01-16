/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectog1;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Orden;
import modelo.Tecnico;
import modelo.TipoVehiculo;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class TecnicoController implements Initializable {
    public static Tecnico tec;

    @FXML
    private Label nombreOpcion;
    @FXML
    private VBox contenidoOpcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultarOrden(ActionEvent event) {
        contenidoOpcion.getChildren().clear();
        TableView tabla = new TableView();
        TableColumn<Orden,String> colCod = new TableColumn<Orden,String>("Codigo");
        colCod.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        TableColumn<Orden,String> colDate = new TableColumn<Orden,String>("Fecha");
        colDate.setCellValueFactory(new PropertyValueFactory<>("FechaString"));
        TableColumn<Orden,String> colCliente = new TableColumn<Orden,String>("Nombre del cliente");
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        TableColumn<Orden,String> colTotal = new TableColumn<Orden,String>("Total a pagar");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("TotalPagar"));
        //ObservableList<Orden> listOrd = FXCollections.observableArrayList(Orden.cargarOrdenes(App.pathOrdenes));
        ObservableList<Orden> listOrd = FXCollections.observableArrayList(tec.getListaOrden());//
        FilteredList<Orden> filteredData = new FilteredList<>(listOrd, p -> true);
        tabla.setItems(filteredData);
        tabla.getColumns().setAll(colCod,colDate,colCliente,colTotal);
        
        TextField searchCod = new TextField();
        searchCod.setPromptText("Buscar Codigo");
        searchCod.textProperty().addListener((prop, old, text) -> {
        filteredData.setPredicate(orden -> {
        if(text == null || text.isEmpty()) return true;
        
        String cod = orden.getCodigo();  
        return cod.contains(text);
         });
        });
        
        TextField searchCliente = new TextField();
        searchCliente.setPromptText("Buscar Cliente");
        searchCliente.textProperty().addListener((prop, old, text) -> {
        filteredData.setPredicate(orden -> {
        if(text == null || text.isEmpty()) 
        
        return true;
        
        String cod = orden.getCliente().getNombre().toLowerCase();  
        return cod.contains(text.toLowerCase());
         });
        });
        
        TextField searchDate = new TextField();
        searchDate.setPromptText("Buscar fecha");
        searchDate.textProperty().addListener((prop, old, text) -> {
        filteredData.setPredicate(orden -> {
        if(text == null || text.isEmpty()) return true;
        //SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        //String fecha = fmt.format(orden.getFecha());  
        String fecha = orden.getFecha().getTime().toLocaleString();
        return fecha.contains(text.toLowerCase());
         });
        });
        
        HBox searchBar = new HBox();
        searchBar.getChildren().addAll(searchCod,searchCliente,searchDate);
        
        //Se llena la tabla 
        //tabla.getItems().setAll(Orden.cargarOrdenes(App.pathOrdenes));
        nombreOpcion.setText("Consultar Orden");
        Button botDetalle = new Button("Detalle");
        Label detalle = new Label();
        contenidoOpcion.getChildren().addAll(searchBar,tabla,botDetalle,detalle);
        botDetalle.setOnAction(e->{
        detalle.setText("");
        Orden ordenSelect = (Orden) tabla.getSelectionModel().getSelectedItem();
        detalle.setText("Codigo: "+ ordenSelect.getCodigo()+"\nFecha: "+ ordenSelect.getFecha().getTime().toLocaleString()+"\nNombre del cliente: "+ 
                ordenSelect.getCliente().getNombre()+"\nPlacaVehiculo: "+ordenSelect.getPlacaVehiculo()+"\nTipo de vehiculo: "+ ordenSelect.getTipoVehiculo());
        
        });
        contenidoOpcion.getChildren().add(detalle);
        
        
        
    }

    @FXML
    private void generarOrden(ActionEvent event) {
        contenidoOpcion.getChildren().clear();
        
        Label codigo = new Label("Codigo: ");
        codigo.setPrefSize(120, 30);
        
        TextField llenarcode = new TextField();
        llenarcode.setPrefSize(100, 30);
        llenarcode.setPromptText("Digite código del cliente");
        
        Label fecha = new Label("Fecha: ");
        fecha.setPrefSize(120, 30);
        
        TextField llenarFecha = new TextField();
        llenarFecha.setPrefSize(100, 30);
        llenarFecha.setPromptText("Digite la fecha del servicio");
        
        Label placa = new Label("Placa del vehiculo:  ");
        placa.setPrefSize(120, 30);
        TextField llenarPlaca = new TextField();
        llenarPlaca.setPrefSize(100, 30);
        llenarPlaca.setPromptText("Digite la placa del vehiculo");
        
        
        
        
        
        Label tipo = new Label("Tipo de vehiculo");
        HBox b = new HBox();
        
        tipo.setPrefSize(120, 30);
        RadioButton automovil = new RadioButton();
        Label aut = new Label("Automovil");
        RadioButton motocicletas = new RadioButton();
        Label mot = new Label("Motocicletas");
        RadioButton bus = new RadioButton();
        Label bus1 = new Label("Bus");
        
        ToggleGroup tg = new ToggleGroup();
        automovil.setToggleGroup(tg);
        motocicletas.setToggleGroup(tg);
        bus.setToggleGroup(tg);
        
        b.getChildren().addAll(automovil,aut,motocicletas,mot,bus,bus1);
        
        
        b.setMargin(automovil, new Insets(5,5,5,5));
        b.setMargin(motocicletas, new Insets(5,5,5,5));
        b.setMargin(bus, new Insets(5,5,5,5));
        
        contenidoOpcion.getChildren().addAll(codigo, llenarcode,fecha,llenarFecha, placa, llenarPlaca,tipo,b);
        contenidoOpcion.setMargin(codigo, new Insets(0, 0, 5,0));
        contenidoOpcion.setMargin(fecha, new Insets(5, 0, 5, 0));
        contenidoOpcion.setMargin(placa, new Insets(5, 0, 5, 0));
        
        
        if(automovil.isSelected()){
            TipoVehiculo t = TipoVehiculo.AUTOMOVIL;
        }
        else if(motocicletas.isSelected()){
            TipoVehiculo l = TipoVehiculo.MOTOCICLETAS;
        }else if(bus.isSelected()){
            TipoVehiculo t =  TipoVehiculo.BUS;
        }
       /* 
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
        */
        
    }

    @FXML
    private void reportarFalta(ActionEvent event) {
    }
    
}
