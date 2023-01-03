module com.mycompany.proyectog1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectog1 to javafx.fxml;
    exports com.mycompany.proyectog1;
}
