package com.github.plushaze.traynotification;

import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

// https://github.com/PlusHaze/TrayNotification

public class Main {
  public static void main(String[] args) throws InterruptedException {
    final CountDownLatch latch = new CountDownLatch(1);
    SwingUtilities.invokeLater(() -> {
      new JFXPanel();
      latch.countDown();
    });

    latch.await();

    String title = "Download quota reached";
    String message = "Your \ndownload \nquota \nhas \nbeen \nreached. \nPanic.";
    Notification notification = Notifications.NOTICE;

    Platform.runLater(() -> {
      try {
        Unirest.post("http://httpbin.org/post")
                .queryString("name", "Mark")
                .field("last", "Polo")
                .asJson()
        ;
      } catch (UnirestException e) {
        e.printStackTrace();
      }

      TrayNotification tray = new TrayNotification();
      tray.setTitle(title);
      tray.setMessage(message);
      tray.setNotification(notification);
      tray.setAnimation(Animations.POPUP);
      tray.showAndWait();
    });
  }
}
