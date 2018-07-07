package org;

import org.github.GitHubApi;
import org.github.PullRequest;
import org.store.Assignment;
import org.store.Store;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static org.github.GitHubApi.*;
import static org.notifications.CustomNotifications.showAssignement;

public class Clock {
  public static boolean isTicking;

  public static void forEach(long sec, Runnable toDo) {
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        toDo.run();
      }
    };

    timer.schedule(timerTask, 0, sec * 1000);
  }

  public static void tickForAssignmentUpdates() {
    if (!isTicking && validateInformation(Store.get())) {
      Clock.forEach(60, () -> {
        List<PullRequest> pulls = getPulls(Store.get());
        List<Assignment> newAssignments = Store.load(pulls);
        List<Assignment> allAssignments = Store.get().getAssignments();

        if (!newAssignments.isEmpty()) {
          showAssignement(newAssignments, allAssignments);
        }
      });

      isTicking = true;
    }
  }
}
