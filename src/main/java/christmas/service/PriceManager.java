package christmas.service;

import christmas.domain.Event;
import christmas.dto.EventDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;

public class PriceManager {
    private final int DISCOUNT_STARDAY = 1000;
    private final DateManager date;
    private final MenuManager menu;
    private final Event event;

    public PriceManager(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
        this.event = new Event();
    }

    public int calculateMenuPrice() {
        return menu.getMenusPrice();
    }

    public int calculateMenuDiscounts() {
        String weekendDiscount = date.getWeekendDiscount();
        int menuDiscount = menu.getMenusDiscount(weekendDiscount);
        return menuDiscount;
    }

    public int calculateStarDayDiscount() {
        if (date.isStared()) {
            return DISCOUNT_STARDAY;
        }
        return 0;
    }

    public int calculateDDayDiscount() {
        return date.getDDayDiscount();
    }

    public EventDTO getEventInformation() {
        return event.toDTO();
    }

}
