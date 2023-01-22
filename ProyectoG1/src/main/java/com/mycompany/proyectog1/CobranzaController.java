/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectog1;

import static com.mycompany.proyectog1.TecnicoController.listaOrdenTec;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import modelo.Admin;
import modelo.Cliente;
import modelo.Orden;
import modelo.Servicio;
import modelo.Tecnico;
import modelo.TipoCliente;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CobranzaController implements Initializable {

    @FXML
    private Label lblOpcion;
    @FXML
    private VBox contenidoBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generarFacturas(ActionEvent event) {
        contenidoBox.getChildren().clear();
        lblOpcion.setText("Generar facturas");
        ArrayList<Orden> ordFilt = new ArrayList<>();
        String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        ArrayList<Orden> ordenes = Orden.cargarOrdenes(App.pathOrdenes);
        Label codigo = new Label("Codigo del cliente: ");
        codigo.setPrefSize(120, 30);
        
        TextField llenarCode = new TextField();
        llenarCode.setPrefSize(100, 30);
        llenarCode.setPromptText("Digite código del cliente");
        
        Label periodo = new Label("Periodo de facturación:  ");
        periodo.setPrefSize(120, 30);
        
        TextField llenarPer = new TextField();
        llenarPer.setPrefSize(100, 30);
        llenarPer.setPromptText("Inserte mes-año mm-yyyy");
        
        Button botGen = new Button("Generar");
        contenidoBox.getChildren().addAll(codigo,llenarCode,periodo,llenarPer,botGen);
        
        
        botGen.setOnAction(e->{
        GridPane gridPane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);
        for (int i = 0; i < 2; i++) {
            RowConstraints row = new RowConstraints(10);
            gridPane.getRowConstraints().add(row);
        }
        Label lblCod1 = new Label(Cliente.buscarCliente(llenarCode.getText()).getNombre());

        gridPane.getColumnConstraints().addAll(col1, col2);

        Label lblCod = new Label("Empresa");
        gridPane.add(lblCod, 0, 0);

        gridPane.add(lblCod1, 1, 0);
        String[] dateList = llenarPer.getText().split("-");
        int mes = Integer.valueOf(dateList[0]);
        int agno = Integer.valueOf(dateList[1]);
        Label lblDat1 = new Label("Periodo de facturación: ");
        Label lblDat2 = new Label( MES[mes-1]+" "+ agno);
        gridPane.add(lblDat1, 0, 1);
        gridPane.add(lblDat2, 1, 1);
        
        TableView tabla = new TableView();
        TableColumn<Orden,String> colPla = new TableColumn<Orden,String>("Placa");
        colPla.setCellValueFactory(new PropertyValueFactory<>("placaVehiculo"));
        TableColumn<Orden,String> colDate = new TableColumn<Orden,String>("Fecha");
        colDate.setCellValueFactory(new PropertyValueFactory<>("FechaString"));
        TableColumn<Orden,String> colTip = new TableColumn<Orden,String>("Tipo");
        colTip.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
        TableColumn<Orden,String> colSer = new TableColumn<Orden,String>("Servicio");
        colSer.setCellValueFactory(new PropertyValueFactory<>("stringServicio"));
        TableColumn<Orden,String> colCant = new TableColumn<Orden,String>("Cantidad");
        colCant.setCellValueFactory(new PropertyValueFactory<>("stringCantidad"));
        TableColumn<Orden,String> colTotal = new TableColumn<Orden,String>("Total");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("TotalPagar"));
        tabla.getColumns().setAll(colPla,colDate,colTip,colSer,colCant,colTotal);
        
        int total = 50;
        ArrayList<Servicio> listServ = new ArrayList<>();
        ArrayList<Integer> listCant = new ArrayList<>();
        for(Orden o: ordenes){
                    if(o.getCliente().getTipoCliente_1() == TipoCliente.EMPRESARIAL){
                        System.out.println("Si es empresa");
                        System.out.println((o.getFecha().get(Calendar.MONTH)+1)+" compara con "+mes);
                        System.out.println((o.getFecha().get(Calendar.YEAR))+" compara con "+agno);

                    if((o.getFecha().get(Calendar.MONTH)+1) == mes && (o.getFecha().get(Calendar.YEAR) == agno )){
                        System.out.println("Si cumple año y mes");
                        
                    for(int i =0; i<(o.getServicios().size());i++){
                     // tabla.getItems().addAll(o.getPlacaVehiculo(),o.getFecha().getTime().toLocaleString(),o.getTipoVehiculo(),
                               // o.getServicios().get(i).getNombre(),o.getCantidad().get(i),(o.getServicios().get(i).getPrecio()*o.getCantidad().get(i)));
                        listServ.clear();
                        listCant.clear();
                        listServ.add(o.getServicios().get(i));
                        
                        listCant.add(o.getCantidad().get(i));
                       Orden o2 = new Orden(o.getCliente(),o.getFecha(),o.getPlacaVehiculo(),o.getTipoVehiculo(),listServ,listCant);
                        ordFilt.add(o2);
                        
                        
                        
                        
                        total += o.getServicios().get(i).getPrecio()*o.getCantidad().get(i);
                        

                    }
                    
                }
                }}
        ObservableList<Orden> listOrd = FXCollections.observableArrayList(ordFilt);
        tabla.setItems(listOrd);
        Label lblTotal = new Label("Total a pagar: " + total);
        contenidoBox.getChildren().setAll(gridPane,tabla,lblTotal);
        });
        
    }

    @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        App.setRoot("vista_login");
    }
    
    
    
    public class ServicioXmes {
           public Servicio s;
           public int mes;
           public int agno;
           public double total;
             public ServicioXmes(Servicio s,int mes,int agno,double total){
                this.s= s;
                this.mes = mes;
                this.agno = agno;
                this.total= total;
            }
              public String getNomServicio(){
                 return s.getNombre();
             }
             public double getTotalServ(){
                 return total;
             }
        }
    
    public class TecnicoXserv{
        public Tecnico tec1;
        public double total;
        public TecnicoXserv(Tecnico tec1, double total){
            this.tec1 = tec1;
            this.total = total;
        }
        public String getNomTec(){
            return tec1.getNombre();
        }
        public double getTotalTec(){
            return total;
        }
    }

    @FXML
    private void reporteServicios(ActionEvent event) {
        
        
        
        lblOpcion.setText("Reporte por servicio");
        contenidoBox.getChildren().clear();
       
        Label periodo = new Label("Periodo de consulta:  ");
        periodo.setPrefSize(120, 30);
        
        TextField llenarPer = new TextField();
        llenarPer.setPrefSize(100, 30);
        llenarPer.setPromptText("Inserte mes-año mm-yyyy");
        
        Button botCon = new Button("Consultar");
       contenidoBox.getChildren().addAll(periodo,llenarPer,botCon);
       
       botCon.setOnAction(e->{
       TableView tabla = new TableView();
        TableColumn<ServicioXmes,String> colSer = new TableColumn<ServicioXmes,String>("Servicio");
       colSer.setCellValueFactory(new PropertyValueFactory<>("NomServicio"));
        TableColumn<ServicioXmes,String> colTotal = new TableColumn<ServicioXmes,String>("Total");
       colTotal.setCellValueFactory(new PropertyValueFactory<>("TotalServ"));
        tabla.getColumns().addAll(colSer,colTotal);
        String[] dateList = llenarPer.getText().split("-");
        int mes2 = Integer.valueOf(dateList[0]);
        int agno2 = Integer.valueOf(dateList[1]);
        ArrayList<ServicioXmes> serxmes = new ArrayList<>();
        for(Servicio s: Admin.cargarServicio()){
            double total = Servicio.TotalServicio(s, mes2, agno2);
            ServicioXmes servx = new ServicioXmes(s,mes2,agno2,total);
            serxmes.add(servx);
        }
        ObservableList<ServicioXmes> listOrd = FXCollections.observableArrayList(serxmes);
        tabla.setItems(listOrd);
        contenidoBox.getChildren().add(tabla);
        
       });
       
       
       
       
    }

    @FXML
    private void reporteTecnicos(ActionEvent event) {
        lblOpcion.setText("Reporte por tecnico");
        contenidoBox.getChildren().clear();
       
        Label periodo = new Label("Periodo de consulta:  ");
        periodo.setPrefSize(120, 30);
        
        TextField llenarPer = new TextField();
        llenarPer.setPrefSize(100, 30);
        llenarPer.setPromptText("Inserte mes-año mm-yyyy");
        
        Button botCon = new Button("Consultar");
       contenidoBox.getChildren().addAll(periodo,llenarPer,botCon);
       
       botCon.setOnAction(e->{
       TableView tabla = new TableView();
        TableColumn<ServicioXmes,String> colSer = new TableColumn<ServicioXmes,String>("Tecnicoo");
       colSer.setCellValueFactory(new PropertyValueFactory<>("NomTec"));
        TableColumn<ServicioXmes,String> colTotal = new TableColumn<ServicioXmes,String>("Total");
       colTotal.setCellValueFactory(new PropertyValueFactory<>("TotalTec"));
        tabla.getColumns().addAll(colSer,colTotal);
        String[] dateList = llenarPer.getText().split("-");
        int mes3 = Integer.valueOf(dateList[0]);
        int agno3 = Integer.valueOf(dateList[1]);
        ArrayList<TecnicoXserv> listTec = new ArrayList<>();
        for(Usuario u: Usuario.cargarUsuarios(App.pathUsuarios)){
                if(u.getTipoUsuario()==(TipoUsuario.TECNICO)){
                    Tecnico tec = (Tecnico) u;
                    double totalTec =tec.totalPorTecnico(mes3, agno3);
                    TecnicoXserv tecx = new TecnicoXserv(tec, totalTec);
                    listTec.add(tecx);
                }}
        ObservableList<TecnicoXserv> listTec2 = FXCollections.observableArrayList(listTec);
        tabla.setItems(listTec2);
        contenidoBox.getChildren().add(tabla);
    
});
}
}
