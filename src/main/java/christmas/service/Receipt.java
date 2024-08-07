package christmas.service;

import christmas.dto.DateDTO;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;
import java.util.List;

public class Receipt {
    // Fields, Constructor
    private final DateDTO date;
    private final List<MenuDTO> menus;
    private final PriceDTO price;

    public Receipt(DateDTO date, List<MenuDTO> menus, PriceDTO price) {
        this.date = date;
        this.menus = menus;
        this.price = price;
    }


    // Features
    public DateDTO getDate() {
        return date;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public PriceDTO getPrice() {
        return price;
    }

}
