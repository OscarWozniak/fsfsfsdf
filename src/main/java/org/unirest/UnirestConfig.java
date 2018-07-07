package org.unirest;

import com.mashape.unirest.http.Unirest;

public class UnirestConfig {
  public static void initialize() {
    Unirest.setDefaultHeader("Authorization", "token cb0023c7382febb31a3fc28d159850a560afd379");
  }
}
