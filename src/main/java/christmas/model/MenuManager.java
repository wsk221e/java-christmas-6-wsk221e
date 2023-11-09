package christmas.model;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuManager {
    private final int MENU_MAX_AMOUNT = 20;
    private final List<Menu> menus;

    public MenuManager(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }


    public List<String> getMenuNames() {
        List<String> names = new ArrayList<>();
        for (Menu menu : menus) {
            String name = menu.getName();
            names.add(name);
        }
        return names;
    }

    public List<Integer> getMenuAmounts() {
        List<Integer> amounts = new ArrayList<>();
        for (Menu menu : menus) {
            int amount = menu.getAmount();
            amounts.add(amount);
        }
        return amounts;
    }


    private void validate(List<Menu> menus) {
        validateTotalMenuAmount(menus);
        validateDuplicatedMenu(menus);
        validateMenuOnlyDrinks(menus);
    }

    private void validateTotalMenuAmount(List<Menu> menus) {
        int total = 0;
        for (Menu menu : menus) {
            total += menu.getAmount();
        }
        if (total > MENU_MAX_AMOUNT) {
            throw new IllegalStateException();
        }
    }

    private void validateDuplicatedMenu(List<Menu> menus) {
        Set<String> isDuplicated = new HashSet<>();
        for (Menu menu : menus) {
            String name = menu.getName();
            if (!isDuplicated.add(name)) {
                throw new IllegalStateException();
            }
        }
    }

    private void validateMenuOnlyDrinks(List<Menu> menus) {
        int total = 0;
        int drinks = 0;
        for (Menu menu : menus) {
            if ("음료".equals(menu.getCategory())) {
                total++;
                drinks++;
            }
            if (!"음료".equals(menu.getCategory())) {
                total++;
            }
        }
        if (total == drinks) {
            throw new IllegalStateException();
        }
    }

}
