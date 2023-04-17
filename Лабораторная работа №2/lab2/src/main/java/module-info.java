module com.example.lab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sun.jna;
    requires com.sun.jna.platform;


    opens com.example.lab2 to javafx.fxml;
    exports com.example.lab2;
}