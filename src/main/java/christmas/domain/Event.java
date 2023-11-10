package christmas.domain;

import christmas.dto.EventDTO;

public class Event {
    private int dDayDiscount, menuDiscount, starDiscount;
    private boolean champagneEvent;

    public EventDTO toDTO() {
        int dDay = this.dDayDiscount;
        int menu = this.menuDiscount;
        int star = this.starDiscount;
        boolean champagne = this.champagneEvent;
        return new EventDTO(dDay, menu, star, champagne);
    }

    public void updateChampagneEvent(int bought) {
        champagneEvent = bought >= 120_000;
    }

}
