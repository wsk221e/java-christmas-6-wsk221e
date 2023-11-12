package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.constants.Templates;

public class InputView {
    // Fields
    private final ViewFunction function = new ViewFunction();


    // Features
    public String getUserReserveDate() {
        function.initializeCache();
        function.addToCache(Templates.INPUT_DATE_MESSAGE);
        function.print();

        String input = Console.readLine();
        return input;
    }

    public String getUserReserveMenu() {
        function.initializeCache();
        function.addToCache(Templates.INPUT_MENU_MESSAGE);
        function.print();

        String input = Console.readLine();
        return input;
    }

}
