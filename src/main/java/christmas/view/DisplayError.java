package christmas.view;

import christmas.utils.Templates;

public class DisplayError extends ParentView {
    // Features
    public void displayDateError() {
        initializeCache();
        addToCache(Templates.ERROR_DATE_MESSAEGE);
        print();
    }

}
