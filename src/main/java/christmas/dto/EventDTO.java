package christmas.dto;

import static christmas.utils.constants.Integers.CHAMPAGNE_PRICE;

public class EventDTO {
    public final int dDay, menu, star, total;
    public final boolean hasChampagne;
    public final String badge;

    public EventDTO(int dDay, int menu, int star, boolean champagne, String badge) {
        this.dDay = dDay;
        this.menu = menu;
        this.star = star;
        this.hasChampagne = champagne;
        this.badge = badge;
        this.total = calculateTotal();
    }


    private int calculateTotal() {
        int total = dDay + menu + star;
        if (hasChampagne) {
            total += CHAMPAGNE_PRICE.getValue();
        }
        return total;
    }

}
