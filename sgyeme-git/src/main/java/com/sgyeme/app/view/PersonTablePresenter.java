package com.sgyeme.app.view;

import com.sgyeme.app.model.User;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

public class PersonTablePresenter {
	@FXML
	private TableColumn<User, String> usernameColumn;
	@FXML
	private TableColumn<User, String> fistNameColumn;
	@FXML
	private TableColumn<User, String> lastNameColumn;
	@FXML
	private TableColumn<User, String> phoneColumn;
	@FXML
	private TableColumn<User, Boolean> activeColumn;

	@FXML
	private void initialize() {
		// GridPane
		createTableColumns();
	}

	private void createTableColumns() {
		usernameColumn.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getUsername()));
		usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
		usernameColumn.setStyle("-fx-alignment:CENTER;");

		fistNameColumn.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getFirstName()));
		fistNameColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
		fistNameColumn.setStyle("-fx-alignment:CENTER-LEFT;");

		lastNameColumn.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getLastName()));
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
		lastNameColumn.setStyle("-fx-alignment:CENTER-LEFT;");

		phoneColumn.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getPhone()));
		phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
		phoneColumn.setStyle("-fx-alignment:CENTER-LEFT;");

		activeColumn.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().isActive()));
		activeColumn.setCellFactory(CheckBoxTableCell.forTableColumn(n -> {
			var person = activeColumn.getTableView().getItems().get(n);
			var disabledProperty = new SimpleBooleanProperty(person.isActive());
			disabledProperty.addListener((obs, ov, nv) -> {
				person.setActive(nv);
			});
			return disabledProperty;
		}));

		this.activeColumn.setStyle("-fx-alignment:CENTER;");
		fistNameColumn.getTableView().getSelectionModel().setCellSelectionEnabled(true);
	}

}