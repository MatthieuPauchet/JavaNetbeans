module com.mycompany.papyrusjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.papyrusjdbc to javafx.fxml;
    exports com.mycompany.papyrusjdbc;
}