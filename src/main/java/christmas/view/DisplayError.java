package christmas.view;

import christmas.utils.constants.Templates;

public class DisplayError extends ParentView {
    // Features
    public void displayDateError() {
        initializeCache();
        addToCache(Templates.ERROR_DATE_MESSAEGE);
        print();
    }

    public void displayMenuError() {
        initializeCache();
        addToCache(Templates.ERROR_MENU_MESSAEGE);
        print();
    }

}
