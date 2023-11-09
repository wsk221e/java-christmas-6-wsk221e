package christmas.domain;

import christmas.utils.Menus;

public class Menu {
    private final int AMOUNT_RANGE_MIN = 1;
    private final int AMOUNT_RANGE_MAX = 20;
    private final String menu;
    private final int amount;

    public Menu(String menu, String amountString) {
        int amount = parseInt(amountString);
        validate(menu, amount);

        this.menu = menu;
        this.amount = amount;
    }

    public String getMenu() {
        String string = this.menu;
        return string;
    }

    public int getAmount() {
        int value = this.amount;
        return value;
    }

    private void validate(String menu, int amount) {
        validateMenu(menu);
        validateAmount(amount);
    }

    private void validateMenu(String menu) {
        try {
            Menus.valueOf(menu);
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
