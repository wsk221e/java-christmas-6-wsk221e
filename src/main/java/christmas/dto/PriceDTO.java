package christmas.dto;

public class PriceDTO {
    public final int price;
    public final EventDTO event;

    public PriceDTO(int price, EventDTO event) {
        this.price = price;
        this.event = event;
    }

}
