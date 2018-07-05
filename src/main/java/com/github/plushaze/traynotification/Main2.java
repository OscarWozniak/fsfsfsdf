package com.github.plushaze.traynotification;

import com.github.plushaze.traynotification.notification.custom.CustomNotifications;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
* Notifications
* Emails - https://stackoverflow.com/questions/20613569/java-mail-api-send-emails-via-corporate-outlook-acount
*
* */

import static com.github.plushaze.traynotification.notification.custom.CustomNotifications.*;

public class Main2 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Button button = new Button("sdfsfsf");
    Group group = new Group(button);

    button.setOnMouseClicked(event -> {
      String message = "Your \ndownload \nquota \nhas \nbeen \nreached. \nPanic.";
      assignement(message);
    });

    Scene scene = new Scene(group, 600, 300);
    scene.setFill(Color.BROWN);
    primaryStage.setTitle("Sample Application");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
