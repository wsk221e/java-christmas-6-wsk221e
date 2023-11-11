package christmas.controller;

import christmas.view.DisplayError;
import christmas.view.InputView;

public class RequestController {
    private final InputView input = new InputView();
    private final DisplayError error = new DisplayError();


    public String getUserDate() {
        return input.getUserReserveDate();
    }

    public void displayDateError() {
        error.displayDateError();
    }

    public String getUserMenu() {
        return input.getUserReserveMenu();
    }

    public void displayMenuError() {
        error.displayMenuError();
    }

}
