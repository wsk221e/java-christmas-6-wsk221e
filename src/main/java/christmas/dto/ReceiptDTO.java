package christmas.dto;

public class ReceiptDTO {
    private final int date;
    private final MenusDTO menus;
    private final int price;
    private final EventDTO discount;

    public ReceiptDTO(int date, MenusDTO menus, int price, EventDTO discount) {
        this.date = date;
        this.menus = menus;
        this.price = price;
        this.discount = discount;
    }

}
