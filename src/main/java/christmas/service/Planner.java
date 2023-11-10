package christmas.service;

import christmas.domain.Badges;
import christmas.domain.Price;
import christmas.dto.EventDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import java.util.List;

public class Planner {
    private final DateManager date;
    private final MenuManager menu;
    private final PriceManager priceManager;

    public Planner(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
        this.priceManager = new PriceManager(date, menu);
    }

    public Price getTotalPrice() {
        Price price = priceManager.calculateTotalPrice();
        return price;
    }

    public String getEventBadge() {
        int benefit = calculateTotalBenefit();
        String badge = Badges.getBadgeByBenefit(benefit);
        return badge;
    }

    private int calculateTotalBenefit() {
        EventDTO event = priceManager.getEventInformation();
        List<Integer> benefits = event.getDiscountInfo();
        int totalBenefits = benefits.get(0);
        return totalBenefits;
    }

}
