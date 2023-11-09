package christmas.model;

import christmas.domain.Date;
import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private MenuManager menu;

    public void processDate(String string) {
        Date date = new Date(string);
    }

    public void processMenu(String string) {
        generateMenus(string);
    }

    private void generateMenus(String string) {
        List<Menu> menus = new ArrayList<>();

        List<String> menuAndAmountList = List.of(string.split(","));
        for (String menuAndAmount : menuAndAmountList) {
            List<String> menu = List.of(menuAndAmount.split("-"));
            if (!(menu.size() == 2)) {
                throw new IllegalArgumentException();
            }
            menus.add(new Menu(menu.get(0), menu.get(1)));
        }
        menu = new MenuManager(menus);
    }

}
