package christmas.utils.validation;

import static christmas.utils.constants.Integers.DATE_RANGE_MAX;
import static christmas.utils.constants.Integers.DATE_RANGE_MIN;
import static christmas.utils.constants.Integers.MENU_SPLIT_SIZE;
import static christmas.utils.constants.Strings.MENU_ONLY_FORBIDDEN;

import christmas.domain.enums.Menus;
import christmas.dto.MenuDTO;
import christmas.utils.constants.Integers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    // Fields
    private static final int AMOUNT_RANGE_MIN = Integers.AMOUNT_RANGE_MIN.getValue();
    private static final int AMOUNT_RANGE_MAX = Integers.AMOUNT_RANGE_MAX.getValue();


    // Features
    public static void validateDate(int date) {
        if (date < DATE_RANGE_MIN.getValue() || date > DATE_RANGE_MAX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenu(String name, int amount) {
        validateMenuName(name);
        validateMenuAmount(amount);
    }

    public static void validateMenus(List<MenuDTO> menus) {
        validateMenusTotalAmount(menus);
        validateMenusDuplicated(menus);
        validateMenusOnlyDrinks(menus);
    }

    public static void validateParsedMenuLength(List<String> menu) {
        if (!(menu.size() == MENU_SPLIT_SIZE.getValue())) {
            throw new IllegalArgumentException();
        }
    }


    // Internal Implements
    // 메뉴 각각의 이름을 검증한다.
    private static void validateMenuName(String name) {
        try {
            Menus.valueOf(name);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 메뉴 각각의 수량을 검증한다.
    private static void validateMenuAmount(int amount) {
        if (amount < AMOUNT_RANGE_MIN || amount > AMOUNT_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    // 메뉴 목록의 총 수량을 검증한다.
    private static void validateMenusTotalAmount(List<MenuDTO> menus) {
        int total = 0;
        for (MenuDTO menu : menus) {
            total += menu.amount;
        }
        if (total > AMOUNT_RANGE_MAX) {
            throw new IllegalStateException();
        }
    }

    // 메뉴 목록의 중복을 검증한다.
    private static void validateMenusDuplicated(List<MenuDTO> menus) {
        Set<String> isDuplicated = new HashSet<>();
        for (MenuDTO menu : menus) {
            String name = menu.name;
            if (!isDuplicated.add(name)) {
                throw new IllegalStateException();
            }
        }
    }

    // 메뉴 목록에 음료만 있는지 검증한다.
    private static void validateMenusOnlyDrinks(List<MenuDTO> menus) {
        int total = 0;
        int forbidden = 0;
        for (MenuDTO menu : menus) {
            boolean forbiddenCondition = menu.category.equals(MENU_ONLY_FORBIDDEN.getName());
            if (forbiddenCondition) {
                total++;
                forbidden++;
            }
            if (!forbiddenCondition) {
                total++;
            }
        }
        if (total == forbidden) {
            throw new IllegalStateException();
        }
    }

}
