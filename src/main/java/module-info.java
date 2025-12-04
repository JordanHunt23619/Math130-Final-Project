module math130.mathtestclass {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires javafx.base;


    opens math130.mathtestclass to javafx.fxml;
    exports math130.mathtestclass;
}