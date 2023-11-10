package christmas.dto;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private final int dDay, menu, star;
    private final boolean champagne;

    public EventDTO(int dDay, int menu, int star, boolean champagne) {
        this.dDay = dDay;
        this.menu = menu;
        this.star = star;
        this.champagne = champagne;
    }

    public List<Integer> getDiscountInfo() {
        return new ArrayList<>(List.of(dDay, menu, star));
    }

    public boolean isChampagneEvent() {
        return champagne;
    }

}
