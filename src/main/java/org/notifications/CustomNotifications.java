package org.notifications;

import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.application.Platform;
import org.store.Assignment;

import java.util.List;

public class CustomNotifications {

  public static void showAssignement(List<Assignment> newAssignments, List<Assignment> allAssignments) {
    showAssignement(newAssignments.size(), allAssignments.size());
  }

  public static void showAssignement(int newAssignments, int allAssignments) {
    Platform.runLater(() -> {
      TrayNotification tray = new TrayNotification();
      tray.setTitle("GitHub: New Assignment");
      tray.setMessage("New: " + newAssignments + "\nAll: " + allAssignments);
      tray.setNotification(Notifications.WARNING);
      tray.setAnimation(Animations.SLIDE);
      tray.showAndWait();
//      Quote
//      Andrii: Just do it!
//      Oskar: Or buy premium.
    });
  }
}
