package christmas.model;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.service.Planner;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final int INDEXOF_MENU = 0;
    private static final int INDEXOF_AMOUNT = 1;
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

    public void generatePlanner() {
        planner = new Planner(dateManager, menuManager);
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
        if (!(menu.size() == 2)) {
            throw new IllegalArgumentException();
        }
    }

}
