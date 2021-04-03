package com.sgyeme.app;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;

public class AppFxmLoader {
	private ObjectProperty<Object> presenterProperty;
	private FXMLLoader fxmlLoader;
	public AppFxmLoader() {
		presenterProperty = new SimpleObjectProperty<>();

	}

	public <X> void loadView(Class<X> presenterClass) {
		try {
			fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(presenterClass.getResource(name(presenterClass)));
			//fxmlLoader.setControllerFactory(injector::getInstance);
			fxmlLoader.load();
		} catch (IOException ex) {
			throw new ResourceNotFoundException(ex);
		}
	}

	/*
	 * public <X> void loadViewX(Class<X> presenterClass) { try { fxmlLoader = new
	 * FXMLLoader();
	 * fxmlLoader.setLocation(presenterClass.getResource(name(presenterClass)));
	 * fxmlLoader.load(); } catch (IOException ex) { throw new
	 * ResourceNotFoundException(ex); }
	 * 
	 * }
	 */

	public <X> void loadView(Class<X> presenterClass, Callback<Class<?>, Object> coFactory) {
		try {
			fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(presenterClass.getResource(name(presenterClass)));
			if (coFactory != null) {
				fxmlLoader.setControllerFactory(coFactory);
			}
			fxmlLoader.load();
		} catch (IOException ex) {
			throw new ResourceNotFoundException(ex);
		}

	}

	private static String name(Class<?> presenter) {
		int nameLegth = presenter.getSimpleName().toUpperCase().replace("CONTROLLER", "").replace("PRESENTER", "")
				.length();
		String name = presenter.getSimpleName().substring(0, nameLegth);
		return name + ".fxml";
	}

	public static String createFxml(Class<?> presenter) {
		return name(presenter);
	}

	public Parent getParent() {
		initializeFXMLLoader();
		return (Parent) fxmlLoader.getRoot();
	}

	private void initializeFXMLLoader() {
		if (fxmlLoader != null) {
			presenterProperty.set(fxmlLoader.getController());
		}

	}

	@SuppressWarnings("unchecked")
	public <T> T getPresenter() {
		initializeFXMLLoader();
		return (T) presenterProperty.get();
	}

	public <T> Map<String, Object> getNamespace() {
		initializeFXMLLoader();

		return fxmlLoader.getNamespace();
	}

	public void getPresenter(Consumer<Object> consumer) {
		presenterProperty.addListener((obs, ov, nv) -> {
			consumer.accept(nv);
		});
	}

};