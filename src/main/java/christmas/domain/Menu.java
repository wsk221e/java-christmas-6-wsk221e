package christmas.domain;

import static christmas.utils.validation.ValidatorMenu.validateMenu;

import christmas.domain.enums.Menus;
import christmas.dto.MenuDTO;
import christmas.utils.Utils;

public class Menu {
    private final String name;
    private final String category;
    private final int amount;

    public Menu(String name, String amountString) {
        int amount = Utils.parseInt(amountString);
        validateMenu(name, amount);

        this.category = Menus.getCategoryByName(name);
        this.name = name;
        this.amount = amount;
    }

    public MenuDTO toDTO() {

        return new MenuDTO(name, category, amount, getPrice());
    }

    private int getPrice() {
        return Menus.getPriceByName(name);
    }

}
