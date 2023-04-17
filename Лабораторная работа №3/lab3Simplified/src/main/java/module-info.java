module com.example.lab3simplified {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab3simplified to javafx.fxml;
    exports com.example.lab3simplified;
}