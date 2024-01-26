module com.generator.generator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.generator.generator to javafx.fxml;
    exports com.generator.generator;
}