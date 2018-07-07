package org.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.browser.Browser;

public class InformationTab extends Tab {
  public InformationTab() {
    super("Status");
    VBox hbox = new VBox();
    TableView table = new TableView();

    TableColumn dateCol = new TableColumn("Date");
    TableColumn titleCol = new TableColumn("Title");
    titleCol.setMinWidth(215);

    table.getColumns().addAll(dateCol, titleCol);


//    Todo attach to links
    Hyperlink hyperlink = new Hyperlink("https://github.com/pulls/assigned");
    hyperlink.setOnAction(event -> Browser.open("https://github.com/pulls/assigned"));

    Hyperlink hyperlink1 = new Hyperlink("https://github.com/OscarWozniak/fsfsfsdf");
    hyperlink1.setOnAction(event -> Browser.open("https://github.com/OscarWozniak/fsfsfsdf"));

    hbox.getChildren().addAll(
            new Label("All Assignments"),
            table,
            new Label("Assignment link: "),
            hyperlink,
            new Label("Repository link: "),
            hyperlink1
    );

    setContent(hbox);
  }
}
