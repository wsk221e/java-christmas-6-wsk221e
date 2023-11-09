package christmas.controller;

import christmas.view.InputView;

public class Controller {
    private final InputView input = new InputView();

    
    public void start() {
        getUserReserveDate();
        getUserReserveMenu();
    }


    private void getUserReserveDate() {
        input.getUserReserveDate();
    }

    private void getUserReserveMenu() {
        input.getUserReserveMenu();
    }

}
