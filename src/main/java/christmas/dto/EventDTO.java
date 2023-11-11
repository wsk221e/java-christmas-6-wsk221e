package christmas.dto;

import static christmas.utils.constants.Integers.CHAMPAGNE_PRICE;

import christmas.domain.Badges;

public class EventDTO {
    private final int total, dDay, menu, star;
    private final boolean champagne;

    public EventDTO(int dDay, int menu, int star, boolean champagne) {
        this.dDay = dDay;
        this.menu = menu;
        this.star = star;
        this.champagne = champagne;
        this.total = calculateTotal();
    }

    public boolean isChampagneEvent() {
        return champagne;
    }

    public int getTotalBenefit() {
        int value = total;
        return value;
    }

    public String getEventBadge() {
        int benefit = getTotalBenefit();
        String badge = Badges.getBadgeByBenefit(benefit);
        return badge;
    }

    private int calculateTotal() {
        int total = dDay + menu + star;
        if (champagne) {
            total += CHAMPAGNE_PRICE.getValue();
        }
        return total;
    }

}
