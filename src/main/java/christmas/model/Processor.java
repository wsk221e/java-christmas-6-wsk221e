package christmas.model;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.service.Planner;
import christmas.utils.constants.Integers;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final int INDEXOF_MENU = Integers.INDEXOF_MENU.getValue();
    private static final int INDEXOF_AMOUNT = Integers.INDEXOF_AMOUNT.getValue();
    private static final int MENU_SPLIT_SIZE = Integers.MENU_SPLIT_SIZE.getValue();
    private DateManager dateManager;
    private MenuManager menuManager;
    private Planner planner;


    public void processDate(String string) {
        Date date = new Date(string);
        dateManager = new DateManager(date);
    }

    public void processMenu(String string) {
        List<Menu> menus = generateMenus(string);
        menuManager = new MenuManager(menus);
    }

    public Planner generatePlanner() {
        planner = new Planner(dateManager, menuManager);
        return planner;
    }


    private List<Menu> generateMenus(String string) {
        List<Menu> menus = new ArrayList<>();

        List<String> menuAndAmountList = List.of(string.split(","));
        for (String menuAndAmount : menuAndAmountList) {
            List<String> menu = List.of(menuAndAmount.split("-"));
            validateLength(menu);

            menus.add(new Menu(menu.get(INDEXOF_MENU), menu.get(INDEXOF_AMOUNT)));
        }
        return menus;
    }

    private void validateLength(List<String> menu) {
        if (!(menu.size() == MENU_SPLIT_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

}
