package christmas.model;

import static christmas.utils.validation.ValidatorMenu.validateMenus;

import christmas.domain.Menu;
import java.util.List;

public class MenuManager {
    private final int DISCOUNT_WEEKEND = 2023;
    private final List<Menu> menus;

    public MenuManager(List<Menu> menus) {
        validateMenus(menus);
        this.menus = menus;
    }


    public int getMenusPrice() {
        int sum = 0;
        sum += calculateEachPrice();
        return sum;
    }

    public int getMenusDiscount(String weekendDiscount) {
        int sum = 0;
        sum -= calculateEachDiscount(weekendDiscount);
        return sum;
    }

    private int calculateEachPrice() {
        int sum = 0;
        for (Menu menu : menus) {
            int price = menu.getPrice();
            sum += price;
        }
        return sum;
    }

    private int calculateEachDiscount(String weekendDiscount) {
        int sum = 0;
        for (Menu menu : menus) {
            if (menu.isCategory(weekendDiscount)) {
                sum += DISCOUNT_WEEKEND;
            }
        }
        return sum;
    }

}
