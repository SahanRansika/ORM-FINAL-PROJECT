module org.example.healthcarecenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens healthcarecenter.config to jakarta.persistence;
    opens healthcarecenter.entity to org.hibernate.orm.core;
    opens healthcarecenter.dto.tm to javafx.base;

    opens healthcarecenter to javafx.fxml;
    exports healthcarecenter;
    exports healthcarecenter.controller;
    opens healthcarecenter.controller to javafx.fxml;
}