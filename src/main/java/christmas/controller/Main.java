package christmas.controller;

import christmas.service.Planner;
import christmas.service.Receipt;

public class Main {
    private final RequestController request = new RequestController();
    private final Initializer initializer = new Initializer();


    public void start() {
        requestGetUserDate();
        requestGetUserMenu();
        doService();
    }


    private void requestGetUserDate() {
        while (true) {
            try {
                String date = request.getUserDate();
                initializer.processDate(date);
                break;
            } catch (Exception e) {
                request.displayDateError();
            }
        }
    }

    private void requestGetUserMenu() {
        while (true) {
            try {
                String menu = request.getUserMenu();
                initializer.processMenu(menu);
                break;
            } catch (Exception e) {
                request.displayMenuError();
            }
        }
    }

    private void doService() {
        Planner planner = initializer.generatePlanner();
        Receipt result = planner.getReserveInformation();
    }

}
