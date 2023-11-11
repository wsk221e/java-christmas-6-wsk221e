package christmas.utils.constants;

public enum Integers {
    DATE_RANGE_MIN(1),
    DATE_RANGE_MAX(31),
    D_DAY(25),
    CHAMPAGNE_PRICE(25_000),
    DISCOUNT_DDAY_MAX(3400),
    DISCOUNT_DDAY_MULTIPLIER(100),
    DISCOUNT_WEEKEND(2023),
    INDEXOF_MENU(0),
    INDEXOF_AMOUNT(1),
    MENU_SPLIT_SIZE(2),
    DISCOUNT_STARDAY(1000),
    AMOUNT_RANGE_MIN(1),
    AMOUNT_RANGE_MAX(20);

    private final int value;

    Integers(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}