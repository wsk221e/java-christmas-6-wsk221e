package christmas.domain;

import christmas.utils.Menus;

public class Menu {
    private final int AMOUNT_RANGE_MIN = 1;
    private final int AMOUNT_RANGE_MAX = 20;
    private final int DISCOUNT_WEEKEND = 2023;
    private final String name;
    private final int amount;

    public Menu(String name, String amountString) {
        int amount = parseInt(amountString);
        validate(name, amount);

        this.name = name;
        this.amount = amount;
    }


    public int getPrice() {
        return Menus.getPriceByName(name);
    }

    public int getDiscount(Boolean weekendDiscount) {
        if (weekendDiscount) {
            if (getCategory().equals("디저트")) {
                return DISCOUNT_WEEKEND;
            }
            return 0;
        }
        if (!weekendDiscount) {
            if (getCategory().equals("메인")) {
                return DISCOUNT_WEEKEND;
            }
            return 0;
        }
        return 0;
    }

    public String getName() {
        String string = this.name;
        return string;
    }

    public String getCategory() {
        String string = Menus.getCategory(name);
        return string;
    }

    public int getAmount() {
        int value = this.amount;
        return value;
    }


    private void validate(String name, int amount) {
        validateMenu(name);
        validateAmount(amount);
    }

    private void validateMenu(String name) {
        try {
            Menus.valueOf(name);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAmount(int amount) {
        if (amount < AMOUNT_RANGE_MIN || amount > AMOUNT_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }


    private int parseInt(String string) {
        int amount;
        try {
            amount = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

}
