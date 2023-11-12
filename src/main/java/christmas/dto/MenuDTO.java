package christmas.dto;

public class MenuDTO {
    // Fields, Constructor
    public final String name, category;
    public final int amount, price;

    public MenuDTO(String name, String category, int amounts, int price) {
        this.name = name;
        this.category = category;
        this.amount = amounts;
        this.price = price;
    }

}
