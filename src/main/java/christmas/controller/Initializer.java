package christmas.controller;

import static christmas.utils.constants.Integers.INDEXOF_AMOUNT;
import static christmas.utils.constants.Integers.INDEXOF_MENU;
import static christmas.utils.constants.Integers.MENU_SPLIT_SIZE;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import christmas.service.Planner;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private DateManager dateManager;
    private MenuManager menuManager;


    public void processDate(String string) {
        Date date = new Date(string);
        dateManager = new DateManager(date);
    }

    public void processMenu(String string) {
        List<Menu> menus = parseMenus(string);
        menuManager = new MenuManager(menus);
    }

    public Planner generatePlanner() {
        return new Planner(dateManager, menuManager);
    }


    private List<Menu> parseMenus(String string) {
        List<Menu> menus = new ArrayList<>();

        List<String> menuAndAmountList = List.of(string.split(","));
        for (String menuAndAmount : menuAndAmountList) {
            List<String> menu = List.of(menuAndAmount.split("-"));
            validateParseLength(menu);

            menus.add(new Menu(menu.get(INDEXOF_MENU.getValue()), menu.get(INDEXOF_AMOUNT.getValue())));
        }
        return menus;
    }

    private void validateParseLength(List<String> menu) {
        if (!(menu.size() == MENU_SPLIT_SIZE.getValue())) {
            throw new IllegalArgumentException();
        }
    }

}
