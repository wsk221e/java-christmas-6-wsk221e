package christmas.service;

import christmas.model.DateManager;
import christmas.model.MenuManager;

public class Planner {
    private final DateManager date;
    private final MenuManager menu;
    private final PriceManager price;

    public Planner(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
        this.price = new PriceManager(date, menu);
    }

    public void calculateTotalPrice() {
        int total = price.calculateMenuPrice();
        total -= price.calculateMenuDiscounts();
        total -= price.calculateStarDayDiscount();
        total -= price.calculateDDayDiscount();
    }

    public void calculateTotalEvents() {

    }

}
