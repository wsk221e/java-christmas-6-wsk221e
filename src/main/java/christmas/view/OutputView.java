package christmas.view;

import christmas.utils.constants.Templates;

public class OutputView {
    // Fields
    private final ViewFunction function = new ViewFunction();


    // Features
    public void displayFormatString(Templates template, Object... values) {
        String string = template.format(values);
        displayString(string);
    }

    public void displayString(String string) {
        function.initializeCache();
        function.addToCache(string);
        function.print();
    }

    public void displayString(Templates string) {
        function.initializeCache();
        function.addToCache(string);
        function.print();
    }

}
