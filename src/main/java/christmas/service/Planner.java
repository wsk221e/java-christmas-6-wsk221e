package christmas.service;

import christmas.model.DateManager;
import christmas.model.MenuManager;

public class Planner {
    private final DateManager date;
    private final MenuManager menu;

    public Planner(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
    }

    public void calculateTotalPrice() {
        int total = 0;
        total += calculateMenuPrice();
        total -= calculateMenuDiscounts();
    }


    private int calculateMenuPrice() {
        int menuPrice = menu.getMenusPrice();
        return menuPrice;
    }

    private int calculateMenuDiscounts() {
        String weekendDiscount = date.getWeekendDiscount();
        int menuDiscount = menu.getMenusDiscount(weekendDiscount);
        return menuDiscount;
    }

}
