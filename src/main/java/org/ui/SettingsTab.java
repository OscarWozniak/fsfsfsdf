package org.ui;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.github.GitHubApi;
import org.store.Store;

import static org.Clock.tickForAssignmentUpdates;
import static org.github.GitHubApi.*;

public class SettingsTab extends Tab {

  public SettingsTab() {
    setText("Settings");

    GridPane content = new GridPane();
    content.setHgap(10);
    content.setVgap(10);
    content.setPadding(new Insets(10, 10, 0, 10));

// TODO: Properties file
    TextField user_name = new TextField("OscarWozniak");
    TextField repository = new TextField("OscarWozniak/fsfsfsdf");
    Label status = new Label("Status");
    Label subscribed = new Label("FAILED");
    Button connect = new Button("Connect");
    connect.setOnMouseClicked(e -> {
      Store store = Store.get();
      store.setRepository(repository.getText());
      store.setUserName(user_name.getText());

      if(validateInformation(store)){

        tickForAssignmentUpdates();
//    TODO change color
//        subscribed.setStyle("-fx-color: red");
        subscribed.setText("SUBSCRIBED");
      }else{
//    TODO change color
//        subscribed.setStyle("-fx-color: red");
        subscribed.setText("FAILED");
      }

    });

    content.add(new Label("User Name"), 0, 0);
    content.add(user_name, 1, 0);

    content.add(new Label("Repository"), 0, 1);
    content.add(repository, 1, 1);

    content.add(status, 0, 2);
    content.add(subscribed, 1, 2);

    content.add(connect, 1, 3);

    setContent(content);
  }
}
