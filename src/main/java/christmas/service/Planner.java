package christmas.service;

import christmas.model.DateManager;
import christmas.model.MenuManager;

public class Planner {
    private final int DISCOUNT_STAR = 1000;
    private final DateManager date;
    private final MenuManager menu;

    public Planner(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
    }

    public void calculateTotalPrice() {
        int total = calculateMenuPrice();
        total -= calculateMenuDiscounts();
        total -= calculateStarDayDiscount();
    }


    private int calculateMenuPrice() {
        return menu.getMenusPrice();
    }

    private int calculateMenuDiscounts() {
        String weekendDiscount = date.getWeekendDiscount();
        int menuDiscount = menu.getMenusDiscount(weekendDiscount);
        return menuDiscount;
    }

    private int calculateStarDayDiscount() {
        if (date.isStared()) {
            return DISCOUNT_STAR;
        }
        return 0;
    }

}
