package com.github.plushaze.traynotification;

import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main2 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Button button = new Button("sdfsfsf");
    Group group = new Group(button);

    String message = "Your \ndownload \nquota \nhas \nbeen \nreached. \nPanic.";

    button.setOnMouseClicked(event -> {
      Platform.runLater(() -> {
        TrayNotification tray = new TrayNotification();
        tray.setTitle("GitHub: New Assignment");
        tray.setMessage(message);
        tray.setNotification(Notifications.WARNING);
        tray.setAnimation(Animations.POPUP);
        tray.showAndWait();
      });
    });

    Scene scene = new Scene(group ,600, 300);
    scene.setFill(Color.BROWN);
    primaryStage.setTitle("Sample Application");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
