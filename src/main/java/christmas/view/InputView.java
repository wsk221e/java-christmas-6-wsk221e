package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.constants.Templates;

public class InputView extends ParentView {
    // Features
    public String getUserReserveDate() {
        initializeCache();
        addToCache(Templates.INPUT_DATE_MESSAGE);
        print();

        String input = Console.readLine();
        return input;
    }

    public String getUserReserveMenu() {
        initializeCache();
        addToCache(Templates.INPUT_MENU_MESSAGE);
        print();

        String input = Console.readLine();
        return input;
    }

}
