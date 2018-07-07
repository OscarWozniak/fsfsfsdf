package org.ui.table;

import javafx.beans.property.SimpleStringProperty;
import org.store.Assignment;

import java.util.List;
import java.util.stream.Collectors;

public class RowModel {
  private final SimpleStringProperty date;
  private final SimpleStringProperty title;

  public RowModel(String fName, String lName) {
    this.date = new SimpleStringProperty(fName);
    this.title = new SimpleStringProperty(lName);
  }

  public static List<RowModel> of(List<Assignment> assignments) {
    return assignments.stream()
            .map(RowModel::of)
            .collect(Collectors.toList());
  }

  public static RowModel of(Assignment assignment){
    return new RowModel(assignment.getPullNumber() + "", assignment.getPullTitle());
  }

  public String getDate() {
    return date.get();
  }

  public void setDate(String date) {
    this.date.set(date);
  }

  public SimpleStringProperty dateProperty() {
    return date;
  }

  public String getTitle() {
    return title.get();
  }

  public void setTitle(String title) {
    this.title.set(title);
  }

  public SimpleStringProperty titleProperty() {
    return title;
  }
}
