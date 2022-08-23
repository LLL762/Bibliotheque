module com.afpa.bibliotheque {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires javafx.base;
    requires javafx.graphics;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    exports com.afpa.bibliotheque;
    exports com.afpa.bibliotheque.controller;

    opens com.afpa.bibliotheque.controller;
    opens com.afpa.bibliotheque.entity;
}
