module com.ufu.bilheteriadigital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;

    opens com.ufu.bilheteriadigital to javafx.fxml;
    exports com.ufu.bilheteriadigital;
}
