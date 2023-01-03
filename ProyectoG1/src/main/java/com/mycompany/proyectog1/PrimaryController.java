package com.mycompany.proyectog1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private TextField cuadroUser;
    @FXML
    private TextField cuadroContra;
    @FXML
    private VBox imagenComp;
    @FXML
    private ImageView imageComp1;

    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
