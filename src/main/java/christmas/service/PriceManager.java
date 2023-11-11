package christmas.service;

import static christmas.utils.constants.Integers.DISCOUNT_STARDAY;

import christmas.domain.Event;
import christmas.dto.EventDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;

public class PriceManager {
    private final DateManager date;
    private final MenuManager menu;
    private final Event event;

    public PriceManager(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
        this.event = new Event();
    }

    public int getTotalPrice() {
        int total = calculateMenuPrice();
        calculateMenuDiscounts();
        calculateStarDayDiscount();
        calculateDDayDiscount();
        return total;
    }

    public EventDTO getEventStatus() {
        return event.toDTO();
    }


    private int calculateMenuPrice() {
        return menu.getMenusPrice();
    }

    private int calculateMenuDiscounts() {
        String weekendDiscount = date.getWeekendDiscount();
        int menuDiscount = menu.getMenusDiscount(weekendDiscount);
        event.updateMenuDiscount(menuDiscount);
        return menuDiscount;
    }

    private int calculateStarDayDiscount() {
        if (date.isStared()) {
            event.updateStarDiscount(DISCOUNT_STARDAY.getValue());
        }
        return DISCOUNT_STARDAY.getValue();
    }

    private int calculateDDayDiscount() {
        int dDayDiscount = date.getDDayDiscount();
        event.updateDDayDiscount(dDayDiscount);
        return dDayDiscount;
    }

}
