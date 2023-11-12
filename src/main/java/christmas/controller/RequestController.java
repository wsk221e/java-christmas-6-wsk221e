package christmas.controller;

import christmas.utils.constants.Templates;
import christmas.view.InputView;
import christmas.view.OutputView;

public class RequestController {
    // Fields
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();


    // Features
    public String getUserDate() {
        return input.getUserReserveDate();
    }

    public void displayDateError() {
        output.displayString(Templates.ERROR_DATE_MESSAEGE);
    }

    public String getUserMenu() {
        return input.getUserReserveMenu();
    }

    public void displayMenuError() {
        output.displayString(Templates.ERROR_MENU_MESSAEGE);
    }

}
