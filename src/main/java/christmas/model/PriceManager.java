package christmas.model;

import christmas.domain.Event;
import christmas.domain.Price;
import christmas.dto.DateDTO;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;
import java.util.List;

public class PriceManager {
    private final Price price;

    public PriceManager(DateDTO date, List<MenuDTO> menus) {
        Event event = new Event(date, menus);
        this.price = new Price(calculateTotalPrice(menus), event);
    }

    public PriceDTO getPrice() {
        return price.toDTO();
    }


    private int calculateTotalPrice(List<MenuDTO> menus) {
        int sum = 0;
        for (MenuDTO menu : menus) {
            sum += menu.price;
        }
        return sum;
    }

}
