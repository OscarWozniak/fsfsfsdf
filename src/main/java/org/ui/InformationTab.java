package org.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.browser.Browser;
import org.store.Assignment;
import org.store.Store;
import org.ui.table.RowModel;

import java.util.List;

public class InformationTab extends Tab {
  private final ObservableList<RowModel> data =
          FXCollections.observableArrayList(
                  new RowModel("Jacob", "Smith"),
                  new RowModel("Isabella", "Johnson"),
                  new RowModel("Ethan", "Williams"),
                  new RowModel("Emma", "Jones"),
                  new RowModel("Michael", "Brown")
          );

  public InformationTab() {
    super("Status");
    VBox hbox = new VBox();
    TableView table = new TableView<RowModel>();

    TableColumn dateCol = new TableColumn("Date");
    TableColumn titleCol = new TableColumn("Title");
    titleCol.setMinWidth(215);

    dateCol.setCellValueFactory(new PropertyValueFactory<RowModel, String>("date"));
    titleCol.setCellValueFactory(new PropertyValueFactory<RowModel, String>("title"));

    table.getColumns().addAll(dateCol, titleCol);


//    Todo attach to links
    Hyperlink hyperlink = new Hyperlink("https://github.com/pulls/assigned");
    hyperlink.setOnAction(event -> Browser.open("https://github.com/pulls/assigned"));

    Hyperlink hyperlink1 = new Hyperlink("https://github.com/OscarWozniak/fsfsfsdf");
    hyperlink1.setOnAction(event -> Browser.open("https://github.com/OscarWozniak/fsfsfsdf"));

//    observator
    Label all_assignments = new Label("All Assignments: ");


    hbox.getChildren().addAll(
            all_assignments,
            table,
            new Label("Assignment link: "),
            hyperlink,
            new Label("Repository link: "),
            hyperlink1
    );

    List<Assignment> assignments = Store.get().getAssignments();


    all_assignments.setText("All Assignments: " + assignments.size());
    data.setAll(RowModel.of(assignments));

    table.setItems(data);
    setContent(hbox);
  }


}
