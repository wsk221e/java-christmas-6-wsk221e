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

    public void updateMenuDiscount(int menuDiscount) {
        this.menuDiscount += menuDiscount;
    }

    public void updateStarDiscount(int starDiscount) {
        this.starDiscount += starDiscount;
    }

    public void updateDDayDiscount(int dDayDiscount) {
        this.dDayDiscount += dDayDiscount;
    }

    public void updateChampagneEvent(int bought) {
        champagneEvent = bought >= 120_000;
    }

}
