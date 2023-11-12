package christmas.view;

import christmas.utils.constants.Templates;

public class OutputView extends ParentView {
    // Features

    public void displayString(String string) {
        initializeCache();
        addToCache(string);
        print();
    }

    public void displayString(Templates string) {
        initializeCache();
        addToCache(string);
        print();
    }

}
