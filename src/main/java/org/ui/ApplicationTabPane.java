package org.ui;

import javafx.scene.control.TabPane;
import org.store.Store;

import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;
import static org.github.GitHubApi.validateInformation;

public class ApplicationTabPane extends TabPane {
  public ApplicationTabPane() {
    super(new InformationTab(), new SettingsTab(), new FaqTab(), new AboutTab());

    setTabClosingPolicy(UNAVAILABLE);

    int tabToSelect = validateInformation(Store.get()) ? 0 : 1;
    getSelectionModel().select(tabToSelect);
  }
}
