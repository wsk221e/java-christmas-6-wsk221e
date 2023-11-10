package christmas.service;

import christmas.domain.Event;
import christmas.domain.Price;
import christmas.dto.EventDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import christmas.utils.constants.Integers;

public class PriceManager {
    private final int DISCOUNT_STARDAY = Integers.DISCOUNT_STARDAY.getValue();
    private final DateManager date;
    private final MenuManager menu;
    private final Event event;

    public PriceManager(DateManager date, MenuManager menu) {
        this.date = date;
        this.menu = menu;
        this.event = new Event();
    }

    public Price calculateTotalPrice() {
        int total = calculateMenuPrice();
        total -= calculateMenuDiscounts();
        total -= calculateStarDayDiscount();
        total -= calculateDDayDiscount();
        Price price = new Price(total);
        return price;
    }

    public EventDTO getEventInformation() {
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
            event.updateStarDiscount(DISCOUNT_STARDAY);
        }
        return DISCOUNT_STARDAY;
    }

    private int calculateDDayDiscount() {
        int dDayDiscount = date.getDDayDiscount();
        event.updateDDayDiscount(dDayDiscount);
        return dDayDiscount;
    }

}
