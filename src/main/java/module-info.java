module com.afpa.bibliotheque {
	requires javafx.controls;
	requires javafx.fxml;
	requires static lombok;
	requires javafx.base;
	requires javafx.graphics;

	opens com.afpa.bibliotheque to javafx.fxml;

	exports com.afpa.bibliotheque;
	exports com.afpa.bibliotheque.controller;

	opens com.afpa.bibliotheque.controller;

}