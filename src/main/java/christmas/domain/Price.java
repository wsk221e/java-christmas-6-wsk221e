package christmas.domain;

public class Price {
    private final int price;

    public Price(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }

}
