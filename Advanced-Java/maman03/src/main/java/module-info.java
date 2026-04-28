module com.example.maman03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.maman03 to javafx.fxml;
    exports com.example.maman03;
}