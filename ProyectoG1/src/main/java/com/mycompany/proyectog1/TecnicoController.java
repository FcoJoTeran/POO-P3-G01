/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectog1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import modelo.Admin;
import modelo.Cliente;
import modelo.Orden;
import modelo.Servicio;
import modelo.Tecnico;
import modelo.TipoVehiculo;
import modelo.Usuario;

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
    
    public TableView tabla;
    
    public static ArrayList<Orden> listaOrdenTec;
    
    public static final String correo = "reportes@gmail.com";

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
        tabla = new TableView();
        TableColumn<Orden,String> colCod = new TableColumn<Orden,String>("Codigo");
        colCod.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        TableColumn<Orden,String> colDate = new TableColumn<Orden,String>("Fecha");
        colDate.setCellValueFactory(new PropertyValueFactory<>("FechaString"));
        TableColumn<Orden,String> colCliente = new TableColumn<Orden,String>("Nombre del cliente");
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        TableColumn<Orden,String> colTotal = new TableColumn<Orden,String>("Total a pagar");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("TotalPagar"));
        //ObservableList<Orden> listOrd = FXCollections.observableArrayList(Orden.cargarOrdenes(App.pathOrdenes));
        ObservableList<Orden> listOrd = FXCollections.observableArrayList(listaOrdenTec);//
        FilteredList<Orden> filteredData = new FilteredList<>(listOrd, p -> true);
        tabla.setItems(filteredData);
        tabla.getColumns().setAll(colCod,colDate,colCliente,colTotal);
        //añade en un hbox los valores buscar
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
        HBox hbox1 = new HBox(25);
       // Label detalle = new Label();
        contenidoOpcion.getChildren().addAll(searchBar,tabla,botDetalle,hbox1);
        
        //BOTON DETALLE
        botDetalle.setOnAction(e->{
           
        hbox1.getChildren().clear();
        //detalle.setText("");
        Orden ordSel = (Orden) tabla.getSelectionModel().getSelectedItem();
        //detalle.setText("Codigo: "+ ordenSelect.getCodigo()+"\nFecha: "+ ordenSelect.getFecha().getTime().toLocaleString()+"\nNombre del cliente: "+ 
                //ordenSelect.getCliente().getNombre()+"\nPlacaVehiculo: "+ordenSelect.getPlacaVehiculo()+"\nTipo de vehiculo: "+ ordenSelect.getTipoVehiculo());
        GridPane gridPane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);
        
        for(int i= 0; i< ordSel.getServicios().size();i++){
         System.out.println(ordSel.getServicios().get(i));
         System.out.println(ordSel.getCantidad().get(i));
        }
        
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(10);
            gridPane.getRowConstraints().add(row);
        }
        Label lblCod1 = new Label(ordSel.getCodigo());

        gridPane.getColumnConstraints().addAll(col1, col2);

        Label lblCod = new Label("Codigo:");
        gridPane.add(lblCod, 0, 0);

        gridPane.add(lblCod1, 1, 0);

        Label lblDat1 = new Label("Fecha:");
        Label lblDat2 = new Label(ordSel.getFecha().getTime().toLocaleString());
        gridPane.add(lblDat1, 0, 1);
        gridPane.add(lblDat2, 1, 1);
        Label lblCli1 = new Label("Nombre del cliente:");
        Label lblCli2 = new Label(ordSel.getCliente().getNombre() + "");
        gridPane.add(lblCli1, 0, 2);
        gridPane.add(lblCli2, 1, 2);
        
        Label lblPla1 = new Label("Placa del vehiculo:");
        Label lblPla2 = new Label(ordSel.getPlacaVehiculo() + "");
        gridPane.add(lblPla1, 0, 3);
        gridPane.add(lblPla2, 1, 3);

        Label lblTip1 = new Label("Tipo de vehiculo:");
        Label lblTip2 = new Label(ordSel.getTipoVehiculo() + "");
        gridPane.add(lblTip1, 0, 4);
        gridPane.add(lblTip2, 1, 4);
        hbox1.getChildren().addAll( gridPane);
                
                
        });
        
        
        
        
    }

    @FXML
    private void generarOrden(ActionEvent event) {
        
        ArrayList<Integer> arrCant = new ArrayList<>();
        ArrayList<Usuario> users = Usuario.cargarUsuarios(App.pathUsuarios);
        contenidoOpcion.getChildren().clear();
        nombreOpcion.setText("Generar Orden");
        
        Label codigo = new Label("Codigo del cliente: ");
        codigo.setPrefSize(120, 30);
        
        TextField llenarCode = new TextField();
        llenarCode.setPrefSize(100, 30);
        llenarCode.setPromptText("Digite código del cliente");
        
        Label fecha = new Label("Fecha: ");
        fecha.setPrefSize(120, 30);
        
        TextField llenarFecha = new TextField();
        llenarFecha.setPrefSize(100, 30);
        llenarFecha.setPromptText("Digite la fecha dd-mm-yyyy");
        
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
        
        contenidoOpcion.getChildren().addAll(codigo, llenarCode,fecha,llenarFecha, placa, llenarPlaca,tipo,b);
        contenidoOpcion.setMargin(codigo, new Insets(0, 0, 5,0));
        contenidoOpcion.setMargin(fecha, new Insets(5, 0, 5, 0));
        contenidoOpcion.setMargin(placa, new Insets(5, 0, 5, 0));
        
        
        
        Label codServicio = new Label("Codigo de servicio: ");
        codServicio.setPrefSize(120, 30);
        
        TextField llenarCodServicio = new TextField();
        llenarCodServicio.setPrefSize(100, 30);
        llenarCodServicio.setPromptText("Digite el codigo del servicio");
        
      
        
        Label cantServicio = new Label("Cantidad de servicio: ");
        cantServicio.setPrefSize(120, 30);
        
        TextField llenarCantServicio = new TextField();
        llenarCantServicio.setPrefSize(100, 30);
        llenarCantServicio.setPromptText("Digite la cantidad del servicio");
        
        contenidoOpcion.getChildren().addAll(codServicio, llenarCodServicio,
                cantServicio,llenarCantServicio);
        contenidoOpcion.setMargin(codServicio, new Insets(0, 0, 5,0));
        
        contenidoOpcion.setMargin(cantServicio, new Insets(5, 0, 5, 0));
       
        Button b1 = new Button("Agregar Orden");
        Button b2 = new Button("Agregar Servicio");
        contenidoOpcion.getChildren().addAll(b1,b2);
        
        
      
      ArrayList<Servicio> arrser= new ArrayList<>();
      
      // BOTON AGREGAR SERVICIO
        b2.setOnAction(e->{
       


try{
        arrCant.add(Integer.valueOf(llenarCantServicio.getText()));
        Servicio conSer = buscarService(llenarCodServicio.getText());
        System.out.println("SERVICIO ENCONTRADO");
        System.out.println(conSer);
        arrser.add(conSer);
        
        
          //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operacion");
            alert.setContentText("Nuevo servicio agregado exitosamente");

            alert.showAndWait();
/*
        
*/
        llenarCodServicio.setText("");
        
        llenarCantServicio.clear();
            System.err.println(arrser);
        }catch(NumberFormatException num){
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de registro");
                alert.setHeaderText("Información faltante");
                alert.setContentText("Datos con fotmato incorrecto");
                alert.showAndWait();
        }catch(Exception ioex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de registro");
                alert.setHeaderText("Información faltante");
                alert.setContentText("Faltan datos");
                alert.showAndWait();
                ioex.getStackTrace();
        }
        
        });
        
        
        
                
       
        //BOTON AGREGAR ORDEN
        b1.setOnAction(e->{
           
            
          ArrayList<Servicio> arrser1 = new ArrayList<>(arrser);
          ArrayList<Integer> arrCant2 = new ArrayList<>(arrCant);
        
        //serializar la lista
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathUsuarios))){
            String[] fechArray = llenarFecha.getText().split("-");

                //Se hace un split y se crea un objeto de clase Calendar
                int dia = Integer.valueOf(fechArray[0]);
                int mes = Integer.valueOf(fechArray[1]) - 1;
                int anio = Integer.valueOf(fechArray[2]);
                GregorianCalendar cal = new GregorianCalendar(anio, mes, dia);
        Cliente cl = Cliente.buscarCliente(llenarCode.getText());
         TipoVehiculo t = null;
        if(automovil.isSelected()){
            t = TipoVehiculo.AUTOMOVIL;
        }
        else if(motocicletas.isSelected()){
            t = TipoVehiculo.MOTOCICLETAS;
        }else if(bus.isSelected()){
            t =  TipoVehiculo.BUS;
        }
        //Orden ord1= new Orden(cl,cal,llenarPlaca.getText(),t,arrser1,arrCant2);
        Orden ord1 = crearOrden(cl,cal,llenarPlaca.getText(),t,arrser1,arrCant2);
            
        for(Usuario a: users){
      if(a.equals(tec)){
          Tecnico atec = (Tecnico)a;
          atec.getListaOrden().add(ord1); 
          int idx= users.indexOf(a);
          users.set(idx,atec);
          listaOrdenTec.add(ord1);
        } 
    }
            out.writeObject(users);
            out.flush();
            System.out.println(arrser1);
            System.out.println(arrCant2);

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operacion");
            alert.setContentText("Nueva orden agregado exitosamente");

            alert.showAndWait();
            //carga la ventana principal
            
            llenarCodServicio.clear();
           
            llenarCantServicio.clear();
            llenarCode.clear();
            llenarPlaca.clear();
            llenarFecha.clear();
            automovil.setSelected(false);
            motocicletas.setSelected(false);
            bus.setSelected(false);
            
            arrser.clear();
            arrCant.clear();

        }catch(NumberFormatException num){
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de registro");
                alert.setHeaderText("Información faltante");
                alert.setContentText("Datos con formato incorrecto");
                alert.showAndWait();
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de registro");
                alert.setHeaderText("Información faltante");
                alert.setContentText("Faltan datos / codigo no encontrado en el sistema");
                alert.showAndWait();
        } 
        
        });
    }

    @FXML
    private void reportarFalta(ActionEvent event) {
        
        contenidoOpcion.getChildren().clear();
        nombreOpcion.setText("Reportar falta de insumos");
         Label descrip = new Label("Descripción: ");
        descrip.setPrefSize(120, 30);
        
        TextField llenarDescrip = new TextField();
        llenarDescrip.setPrefSize(200, 400);
        llenarDescrip.setPromptText("Escriba la descripción de lo que desee reportar");
        
        Button botonEnviar = new Button("Enviar");
        
        contenidoOpcion.getChildren().addAll(descrip,llenarDescrip,botonEnviar);
        botonEnviar.setOnMouseClicked(e->{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de enviar el reporte?");
        Optional<ButtonType> action = alert.showAndWait();
        // Si hemos pulsado en aceptar
        if (action.get() == ButtonType.OK) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information Dialog");
            alert1.setHeaderText("Resultado de la operación");
            alert1.setContentText("Reporte enviado exitosamente a"+correo);

            alert1.showAndWait();
            llenarDescrip.clear();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Information Dialog");
            alert2.setHeaderText("Resultado de la operación");
            alert2.setContentText("Reporte no enviado");

            alert2.showAndWait();
            llenarDescrip.clear();
        }
        });
        
    }
    @FXML
    public void volvermenu(ActionEvent event) throws IOException{
        
   
        App.setRoot("vista_login");
     
        

    }
    
    public Orden crearOrden(Cliente cl, GregorianCalendar cal, String placa, TipoVehiculo t,
            ArrayList<Servicio> arrser1, ArrayList<Integer> arrCant2) throws IOException{
      if(arrser1.isEmpty() && arrCant2.isEmpty())  {
          throw new IOException();
      }
      Orden ord1= new Orden(cl,cal,placa,t,arrser1,arrCant2);
      return ord1;
    
}
    public static Servicio buscarService(String cod){
        ArrayList<Servicio> servicios = Admin.cargarServicio();
        for(Servicio s: servicios){
            if(cod.equals(s.getCodigo())){
                return s;
            }
        }
        return null;
    }
    
    
}
