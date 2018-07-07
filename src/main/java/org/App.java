package org;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.browser.Browser;
import org.store.Store;
import org.ui.ApplicationTabPane;
import org.unirest.UnirestConfig;

import static org.ui.PrimaryStage.loadProperties;

/*
 * Notifications
 * Emails - https://stackoverflow.com/questions/20613569/java-mail-api-send-emails-via-corporate-outlook-acount
 *
 * */

public class App extends javafx.application.Application {

  public static void main(String[] args) {
    UnirestConfig.initialize();
    Store.initialize();

    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Browser.initialize(this);

    TabPane tabPane = new ApplicationTabPane();

    Group group = new Group();

    Scene scene = new Scene(group, 300, 400);

    BorderPane borderPane = new BorderPane();
    borderPane.prefHeightProperty().bind(scene.heightProperty());
    borderPane.prefWidthProperty().bind(scene.widthProperty());
    borderPane.setCenter(tabPane);
    group.getChildren().add(borderPane);

    Clock.tickForAssignmentUpdates();

    scene.setFill(Color.WHITESMOKE);

    loadProperties(primaryStage, scene);
    primaryStage.show();
  }
}

