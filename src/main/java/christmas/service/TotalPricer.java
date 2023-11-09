package christmas.service;

import christmas.model.DateManager;
import christmas.model.MenuManager;

public class TotalPricer {
    private final DateManager date;
    private final MenuManager menu;

    public TotalPricer(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
    }

    public void calculateTotalPrice() {
        Boolean weekendDiscount = date.isWeekend();
        int middlePrice = menu.getMiddlePrice(weekendDiscount);

    }

}
