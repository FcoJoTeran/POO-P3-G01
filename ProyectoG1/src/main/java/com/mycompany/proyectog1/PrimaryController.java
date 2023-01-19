package com.mycompany.proyectog1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.*;

public class PrimaryController {

    @FXML
    private TextField cuadroUser;
    @FXML
    private PasswordField cuadroContra;
    @FXML
    private VBox imagenComp;
    @FXML
    private ImageView imageComp1;
    @FXML
    private Button botonIniciarSesion;

    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    public static Usuario consulta(Usuario u){
        ArrayList<Usuario> usuarios = Usuario.cargarUsuarios(App.pathUsuarios);
        for(Usuario a: usuarios){
            System.out.println(a.getContrasena());
      if(a.equals(u)){
            return a;
        } 
    }return null;
}
    
    @FXML
    public  void iniciarSesion(){
         
        
        String user = cuadroUser.getText();
        
        String passw = cuadroContra.getText();
        
        Usuario inicioUser = new Admin(user,passw,"",TipoUsuario.ADMIN);
        Usuario consultaUser = consulta(inicioUser);
        try{
          if(consultaUser != null){
            TipoUsuario tipo= consultaUser.getTipoUsuario();
            switch(tipo){
                case ADMIN:{
                    Admin ad =(Admin)consultaUser;
                    mostrarVentanaAdmin();
                    break;
                }
                case TECNICO : {
                    Tecnico tec = (Tecnico)consultaUser;
                    mostrarVentanaTecnico(tec);
                    break;
                }
                case COBRANZAS : {
                    Cobranza cd = (Cobranza)consultaUser;
                    mostrarVentanaCobranza();
                    break;
                }
                default :{
                    System.out.println("No se encontro el tipo de usuario");
                }
                    
            }
            //Tecnico tecnico;
            //tecnico.menu();
                    }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error al iniciar sesión");
            alert.setHeaderText("Error");
            alert.setContentText("Usuario o clave incorrecta");
            alert.showAndWait();
            
        }}
        catch (FileNotFoundException e){
        System.out.println("Error en inicio de sesion:"+ e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error en inicio de sesion:"+ e.getMessage());
        }
         
    }
    public void mostrarVentanaAdmin() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("admin.fxml"));
        AdminController ct = new AdminController();
        
        fxmlLoader.setController(ct);
        BorderPane root = (BorderPane) fxmlLoader.load(); //SE carga el hbox principal de la ventana
        
        
        App.changeRoot(root);
    }
    
    public void mostrarVentanaTecnico(Tecnico tec) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tecnico.fxml"));
        TecnicoController ct = new TecnicoController();
        
        fxmlLoader.setController(ct);
        HBox root = (HBox) fxmlLoader.load(); //SE carga el hbox principal de la ventana
        ct.tec = tec;
        App.changeRoot(root);
    }
    
    public void mostrarVentanaCobranza() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cobranza.fxml"));
        CobranzaController ct = new CobranzaController();
        
        fxmlLoader.setController(ct);
        HBox root = (HBox) fxmlLoader.load(); //SE carga el hbox principal de la ventana
        
        App.changeRoot(root);
    }
    
}
