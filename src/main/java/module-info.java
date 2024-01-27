module com.generator.generator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.generator.generator to javafx.fxml;
    exports com.generator.generator;
}