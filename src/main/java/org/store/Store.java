package org.store;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.Clock;
import org.github.PullRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store {
  private static Store store;
  String userName;
  String repository;
  List<Assignment> assignments;

  private static void loadNewStore(Store s) {
    store = s;
  }

  public static void initialize() {
    try {
      Store s = get();

      File file = new File("./information.json");
      if (file.exists()) {
        Gson gson = new Gson();
        Store store = gson.fromJson(new FileReader("./information.json"), Store.class);
        loadNewStore(store);
      } else {
        save(s);
      }

      Clock.tickForAssignmentUpdates();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void save(Store s) {
    try {
      Gson gson = new Gson();
      String precreatedStore = gson.toJson(s);
      Path newFile = Paths.get("./information.json");
      Files.write(newFile, precreatedStore.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Store get() {
    if (store == null) {
      store = new Store();
    }
    return store;
  }

  public static List<Assignment> load(List<PullRequest> pulls) {
    Store s = get();
    String userName = s.getUserName();
    List<Assignment> oldAssignments = s.getAssignments();

    List<Assignment> allUserAssignments = pulls.stream()
            .filter(pull -> pull.getAssignees().stream().anyMatch(assignees -> assignees.getLogin().equals(userName)))
            .map(pull -> new Assignment(pull.getNumber(), pull.getTitle(), pull.getAssignees().stream().filter(assignees -> assignees.getLogin().equals(userName)).findFirst().get().getId()))
            .collect(Collectors.toList());

    List<Assignment> newlyAddedAssignments = allUserAssignments.stream()
            .filter(assignment -> oldAssignments == null || oldAssignments.stream().noneMatch(old -> old.equals(assignment)))
            .collect(Collectors.toList());

    s.setAssignments(allUserAssignments);

    save(s);

    return newlyAddedAssignments;
  }
}
