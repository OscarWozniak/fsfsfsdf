package com.github.plushaze.traynotification.notification.custom;

import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.application.Platform;

public class CustomNotifications {
  public static void assignement(String message){
    Platform.runLater(() -> {
      TrayNotification tray = new TrayNotification();
      tray.setTitle("GitHub: New Assignment");
      tray.setMessage(message);
      tray.setNotification(Notifications.WARNING);
      tray.setAnimation(Animations.SLIDE);
      tray.showAndWait();
    });

  }
}
