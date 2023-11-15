package christmas.domain;

import static christmas.utils.validation.Validator.validateMenu;

import christmas.domain.enums.Menus;
import christmas.dto.MenuDTO;
import christmas.utils.Utils;

public class Menu {
    // Fields, Constructor
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


    // Features
    public MenuDTO toDTO() {

        return new MenuDTO(name, category, amount, getPrice());
    }


    // Internal Implements
    // Menus로부터 메뉴 이름으로 가격을 반환한다.
    private int getPrice() {
        return Menus.getPriceByName(name);
    }

}
