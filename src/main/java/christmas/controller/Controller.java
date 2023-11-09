package christmas.controller;

import christmas.model.Processor;
import christmas.view.DisplayError;
import christmas.view.InputView;

public class Controller {
    private final InputView input = new InputView();
    private final Processor processor = new Processor();
    private final DisplayError error = new DisplayError();


    public void start() {
        getUserReserveDate();
        getUserReserveMenu();

    }


    private void getUserReserveDate() {
        while (true) {
            try {
                String date = input.getUserReserveDate();
                processor.processDate(date);
                break;
            } catch (Exception e) {
                error.displayDateError();
            }
        }
    }

    private void getUserReserveMenu() {
        input.getUserReserveMenu();
    }

}
