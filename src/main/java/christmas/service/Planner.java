package christmas.service;

import christmas.dto.EventDTO;
import christmas.dto.MenusDTO;
import christmas.dto.ReceiptDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;

public class Planner {
    private final DateManager dateManager;
    private final MenuManager menuManager;
    private final PriceManager priceManager;

    public Planner(DateManager date, MenuManager menu) {
        this.dateManager = date;
        this.menuManager = menu;
        this.priceManager = new PriceManager(date, menu);
    }

    public ReceiptDTO getReceipt() {
        int date = dateManager.getDate();
        MenusDTO menus = menuManager.toDTO();
        int price = priceManager.getTotalPrice();
        EventDTO discounts = priceManager.getEventStatus();

        return new ReceiptDTO(date, menus, price, discounts);
    }

}
