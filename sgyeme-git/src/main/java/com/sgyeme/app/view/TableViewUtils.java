package com.sgyeme.app.view;

import java.util.function.BiPredicate;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public final class TableViewUtils {
	private TableViewUtils() {
	}
	public static <S> void addSearchFilter(TableView<S> table, TextField field, BiPredicate<S, String> pre) {
		var filteredData = new FilteredList<S>(table.getItems(), p -> true);
		field.textProperty().addListener((obs, ov, nv) -> filteredData.setPredicate(t -> pre.test(t, nv)));
		var sortedList = new SortedList<S>(filteredData);
		sortedList.comparatorProperty().bind(table.comparatorProperty());
		table.setItems(sortedList);
	}

}
