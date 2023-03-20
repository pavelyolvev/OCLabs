module com.lab.lab1guiv1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab.lab1guiv1 to javafx.fxml;
    exports com.lab.lab1guiv1;
}