package org.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class AboutTab extends Tab {
  public AboutTab() {
    super();
    setText("About");
    TextArea ta = new TextArea();
    ta.setText("\n1\n1\n1\n1\n1\n111111111111111111111111111111111111111111111111111111");
    setContent(ta);
  }
}
