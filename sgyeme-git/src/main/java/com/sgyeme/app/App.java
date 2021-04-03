package com.sgyeme.app;

import com.sgyeme.app.view.PersonPresenter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class App extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		var loader = new AppFxmLoader();
		loader.loadView(PersonPresenter.class);
		var root = loader.getParent();
		var scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}


}
