package christmas.dto;

public class PriceDTO {
    public final int price, discount, benefit;
    public final EventDTO event;
    public final boolean isChampagne;
    public final String badge;

    public PriceDTO(int price, int discount, int benefit, EventDTO event, boolean isChampagne, String badge) {
        this.price = price;
        this.discount = discount;
        this.benefit = benefit;
        this.event = event;
        this.isChampagne = isChampagne;
        this.badge = badge;
    }

}
