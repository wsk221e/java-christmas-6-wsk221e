package christmas.domain;

import static christmas.utils.validation.ValidatorMenu.validateMenu;

import christmas.utils.Parser;

public class Menu {
    private final String name;
    private final int amount;

    public Menu(String name, String amountString) {
        int amount = Parser.parseInt(amountString);
        validateMenu(name, amount);

        this.name = name;
        this.amount = amount;
    }


    public String getName() {
        String string = this.name;
        return string;
    }

    public int getAmount() {
        int value = this.amount;
        return value;
    }

    public boolean isCategory(String string) {
        String category = Menus.getCategoryByName(name);
        return category.equals(string);
    }

    public int getPrice() {
        return Menus.getPriceByName(name);
    }

}
