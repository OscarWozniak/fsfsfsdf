package org.browser;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.Application;

public class Browser {

  private static HostServicesDelegate BROWSER;

  public static void initialize(Application app) {
    BROWSER = HostServicesFactory.getInstance(app);
  }

  public static void open(String url) {
    BROWSER.showDocument(url);
  }
}
