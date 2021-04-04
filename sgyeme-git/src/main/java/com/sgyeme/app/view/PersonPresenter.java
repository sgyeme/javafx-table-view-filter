package com.sgyeme.app.view;

import java.util.Optional;

import com.sgyeme.app.model.User;
import com.sgyeme.app.model.UserBuilder;
import com.sgyeme.app.model.UserFilter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonPresenter {
	@FXML
	private TextField usernameField;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField phoneField;
	@FXML
	private CheckBox isDisable;
	@FXML
	private TableView<User> personTable;
	@FXML
	private TextField searchField;

	private ObservableList<User> users = FXCollections.observableArrayList();

	@FXML
	private void initialize() {

		personTable.setItems(users);
		addSomeUsers();

		TableViewUtils.addSearchFilter(personTable, searchField, new UserFilter());
	}

	private void addSomeUsers() {
		users.addAll(new UserBuilder().username("sgyeme").firstName("Silas").
				lastName("Joe").phone("02545842223").active(true).build(),
				new UserBuilder().username("chrisy").firstName("Juliana").
				lastName("Koomson").phone("0245878863").active(true).build()
				);
	}

	@FXML
	private void clear() {
		users.clear();
	}

	@FXML
	private void close() {
		Optional.ofNullable(usernameField.getScene()).map(Scene::getWindow).map(Stage.class::cast)
				.ifPresent(Stage::close);
	}

	@FXML
	private void insert() {
		users.add(new UserBuilder().username(usernameField.getText()).firstName(firstNameField.getText())
				.lastName(lastNameField.getText()).phone(phoneField.getText()).active(isDisable.isSelected()).build());

		users.forEach(System.err::println);
	}

	@FXML
	private void remove() {
		var index = personTable.getSelectionModel().getSelectedIndex();
		if (index != -1) {
			users.remove(index);
		}

	}
}
