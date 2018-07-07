package org.github;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.store.Store;

import java.util.List;

public class GitHubApi {
  private static final String BASE_URL = "https://api.github.com/";
  private static final String OK = "OK";


  public static List<PullRequest> getPulls(Store store) {
    String json = null;
    try {
      json = Unirest.get("https://api.github.com/repos/" + store.getRepository() + "/pulls").asJson().getBody().toString();
    } catch (UnirestException e) {
      e.printStackTrace();
    }

    Gson gson = new Gson();
    return gson.fromJson(json, new TypeToken<List<PullRequest>>() {
    }.getType());
  }

  public static boolean validateInformation(Store store) {
    try {
      String userStatus = getRequestUser(store.getUserName()).asJson().getStatusText();
      String repoStatus = getRequestRepository(store.getRepository()).asJson().getStatusText();

      return (userStatus.equals(OK) && repoStatus.equals(OK));
    } catch (UnirestException e) {
      e.printStackTrace();
      return false;
    }
  }

  private static GetRequest getRequestUser(String userName) {
    return Unirest.get(BASE_URL + "users/" + userName);
  }

  private static GetRequest getRequestRepository(String repoPath) {
    return Unirest.get(BASE_URL + "repos/" + repoPath);
  }

}
