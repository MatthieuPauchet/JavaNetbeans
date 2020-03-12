module com.mycompany.slider {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.slider to javafx.fxml;
    exports com.mycompany.slider;
}