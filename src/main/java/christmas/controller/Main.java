package christmas.controller;

import christmas.service.Planner;
import christmas.service.Receipt;

public class Main {
    // Fields
    private final RequestController request = new RequestController();
    private final AnnounceController announce = new AnnounceController();
    private final Initializer initializer = new Initializer();


    // Features
    public void start() {
        requestGetUserDate();
        requestGetUserMenu();
        Receipt result = doService();
        requestDisplayResult(result);
    }


    // Internal Implements
    // 사용자로부터 날짜를 입력받는다.
    private void requestGetUserDate() {
        while (true) {
            try {
                String date = request.getUserDate();
                initializer.processDate(date);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                request.displayDateError();
            }
        }
    }

    // 사용자로부터 메뉴를 입력받는다.
    private void requestGetUserMenu() {
        while (true) {
            try {
                String menu = request.getUserMenu();
                initializer.processMenu(menu);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                request.displayMenuError();
            }
        }
    }

    // 서비스를 수행한 후, 그 결과를 받는다.
    private Receipt doService() {
        Planner planner = initializer.generatePlanner();
        return planner.getReserveInformation();
    }

    // 결과를 출력한다.
    private void requestDisplayResult(Receipt result) {
        announce.displayResult(result);
    }

}
