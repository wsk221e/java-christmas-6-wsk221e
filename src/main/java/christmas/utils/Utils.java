package christmas.utils;

import static christmas.utils.constants.Integers.INDEXOF_AMOUNT;
import static christmas.utils.constants.Integers.INDEXOF_MENU;
import static christmas.utils.validation.Validator.validateParsedMenuLength;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    // Constructor
    private Utils() {

    }


    // Features
    public static int parseInt(String string) {
        int date;
        try {
            date = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return date;
    }

    // (메뉴-수량, 메뉴-수량, ...) 형식의 메뉴를 조건에 맞게 분리한다.
    public static List<Menu> parseMenus(String string) {
        List<Menu> menus = new ArrayList<>();

        List<String> menuAndAmountList = List.of(string.split(","));
        for (String menuAndAmount : menuAndAmountList) {
            List<String> menu = List.of(menuAndAmount.split("-"));
            validateParsedMenuLength(menu);

            menus.add(new Menu(menu.get(INDEXOF_MENU.getValue()), menu.get(INDEXOF_AMOUNT.getValue())));
        }
        return menus;
    }

}
