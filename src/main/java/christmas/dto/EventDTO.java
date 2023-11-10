package christmas.dto;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private final int CHAMPAGNE_PRICE = 25_000;
    private final int total, dDay, menu, star;
    private final boolean champagne;

    public EventDTO(int dDay, int menu, int star, boolean champagne) {
        this.dDay = dDay;
        this.menu = menu;
        this.star = star;
        this.champagne = champagne;
        this.total = calculateTotal();
    }

    public List<Integer> getDiscountInfo() {
        return new ArrayList<>(List.of(dDay, menu, star, total));
    }

    public boolean isChampagneEvent() {
        return champagne;
    }

    private int calculateTotal() {
        int total = dDay + menu + star;
        if (champagne) {
            total += CHAMPAGNE_PRICE;
        }
        return total;
    }

}
