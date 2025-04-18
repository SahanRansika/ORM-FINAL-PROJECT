module org.example.healthcarecenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens healthcarecenter to javafx.fxml;
    exports healthcarecenter;
    exports healthcarecenter.controller;
    opens healthcarecenter.controller to javafx.fxml;
}