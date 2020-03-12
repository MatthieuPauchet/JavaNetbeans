module com.mycompany.checkbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.checkbox to javafx.fxml;
    exports com.mycompany.checkbox;
}