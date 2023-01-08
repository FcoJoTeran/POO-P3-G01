package com.mycompany.proyectog1;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.*;

public class PrimaryController {

    @FXML
    private TextField cuadroUser;
    @FXML
    private TextField cuadroContra;
    @FXML
    private VBox imagenComp;
    @FXML
    private ImageView imageComp1;
    @FXML
    private Button botonIniciarSesion;

    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    public static Usuario consulta(Usuario u){
        ArrayList<Usuario> usuarios = Usuario.cargarUsuarios(App.pathUsuarios);
        for(Usuario a: usuarios){
      if(a.equals(u)){
            return a;
        } 
    }return null;
}
    
    public  void iniciarSesion(){
         
        
        String user = cuadroUser.getText();
        
        String passw = cuadroContra.getText();
        
        Usuario inicioUser = new Admin(user,passw,"",TipoUsuario.ADMIN);
        
          if(consulta(inicioUser)!= null){
            TipoUsuario tipo= consulta(inicioUser).getTipoUsuario();
            switch(tipo){
                case ADMIN:{
                    Admin ad =(Admin)consulta(inicioUser);
                    ad.menu();
                }
                case TECNICO : {
                    Tecnico tec = (Tecnico)consulta(inicioUser);
                    tec.menu();
                }
                case COBRANZAS : {
                    Cobranza cd = (Cobranza)consulta(inicioUser);
                    cd.menu();
                }
                default :{
                }
                    
            }
            //Tecnico tecnico;
            //tecnico.menu();
                    }else{
            System.out.println("Usuario o contraseña incorrecta");
            iniciarSesion();
            
        }
         
    }
    
    
}
