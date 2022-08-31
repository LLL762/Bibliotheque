module com.afpa.bibliotheque {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires javafx.base;
    requires javafx.graphics;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires transitive java.desktop;
    requires org.slf4j;


    exports com.afpa.bibliotheque;
    exports com.afpa.bibliotheque.controller;
    exports com.afpa.bibliotheque.model;
    exports com.afpa.bibliotheque.entity;

    opens com.afpa.bibliotheque.controller;
    opens com.afpa.bibliotheque.entity;
    opens com.afpa.bibliotheque;
    exports com.afpa.bibliotheque.utility;

    opens com.afpa.bibliotheque.utility;

}
