package christmas.service;

import christmas.dto.EventDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import christmas.utils.Badges;
import java.util.List;

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

    public String getEventBadge() {
        int benefit = calculateTotalBenefit();
        String badge = Badges.getBadgeByBenefit(benefit);
        return badge;
    }

    private int calculateTotalBenefit() {
        EventDTO event = price.getEventInformation();
        List<Integer> benefits = event.getDiscountInfo();
        int totalBenefits = benefits.get(0);
        return totalBenefits;
    }

}
