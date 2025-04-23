module org.example.healthcarecenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires static lombok;
    requires mysql.connector.j;
    requires java.management;
    requires java.desktop;

    opens healthcarecenter.controller to javafx.fxml;
    opens healthcarecenter to javafx.fxml;
    opens healthcarecenter.dto.tm to javafx.base;
    opens healthcarecenter.entity to org.hibernate.orm.core;
    exports healthcarecenter;
    exports healthcarecenter.bo;
    opens healthcarecenter.bo to javafx.fxml;
    exports healthcarecenter.bo.impl;
    opens healthcarecenter.bo.impl to javafx.fxml;
}