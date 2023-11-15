package christmas.service;

import christmas.dto.DateDTO;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import christmas.model.PriceManager;
import java.util.List;

public class Planner {
    // Fields, Constructor
    private final DateManager dateManager;
    private final MenuManager menuManager;

    public Planner(DateManager date, MenuManager menu) {
        this.dateManager = date;
        this.menuManager = menu;
    }


    // Features
    public Receipt getReserveInformation() {
        return getOrderDetails();
    }


    // Internal Implements
    // 메뉴 목록을 DTO 형태로 반환한다.
    private Receipt getOrderDetails() {
        DateDTO date = dateManager.getDate();
        List<MenuDTO> menus = menuManager.getMenus();
        PriceDTO price = new PriceManager(date, menus).getPrice();

        return new Receipt(date, menus, price);
    }

}
