package christmas.domain;

import christmas.dto.PriceDTO;

public class Price {
    private final int price;
    private final Event event;

    public Price(int price, Event event) {
        this.price = price;
        this.event = event;
    }

    public PriceDTO toDTO() {
        return new PriceDTO(price, event.toDTO());
    }

}
