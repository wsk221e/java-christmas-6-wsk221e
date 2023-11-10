package christmas.utils.validation;

import static christmas.utils.constants.Strings.MENU_ONLY_FORBIDDEN;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.utils.constants.Integers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorMenu {
    private static final int AMOUNT_RANGE_MIN = Integers.AMOUNT_RANGE_MIN.getValue();
    private static final int AMOUNT_RANGE_MAX = Integers.AMOUNT_RANGE_MAX.getValue();


    public static void validateMenu(String name, int amount) {
        validateMenuName(name);
        validateMenuAmount(amount);
    }

    public static void validateMenus(List<Menu> menus) {
        validateMenusTotalAmount(menus);
        validateMenusDuplicated(menus);
        validateMenusOnlyDrinks(menus);
    }


    private static void validateMenuName(String name) {
        try {
            Menus.valueOf(name);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateMenuAmount(int amount) {
        if (amount < AMOUNT_RANGE_MIN || amount > AMOUNT_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateMenusTotalAmount(List<Menu> menus) {
        int total = 0;
        for (Menu menu : menus) {
            total += menu.getAmount();
        }
        if (total > AMOUNT_RANGE_MAX) {
            throw new IllegalStateException();
        }
    }

    private static void validateMenusDuplicated(List<Menu> menus) {
        Set<String> isDuplicated = new HashSet<>();
        for (Menu menu : menus) {
            String name = menu.getName();
            if (!isDuplicated.add(name)) {
                throw new IllegalStateException();
            }
        }
    }

    private static void validateMenusOnlyDrinks(List<Menu> menus) {
        int total = 0;
        int forbidden = 0;
        for (Menu menu : menus) {
            if (menu.isCategory(MENU_ONLY_FORBIDDEN.getName())) {
                total++;
                forbidden++;
            }
            if (!menu.isCategory(MENU_ONLY_FORBIDDEN.getName())) {
                total++;
            }
        }
        if (total == forbidden) {
            throw new IllegalStateException();
        }
    }

}
