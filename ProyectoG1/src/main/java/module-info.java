module com.mycompany.proyectog1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectog1 to javafx.fxml;
    opens modelo to javafx.base;
    exports com.mycompany.proyectog1;
}
