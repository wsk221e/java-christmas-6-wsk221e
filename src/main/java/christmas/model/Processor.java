package christmas.model;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.service.TotalPricer;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private DateManager dateManager;
    private MenuManager menuManager;
    private TotalPricer totalPricer;

    public void processDate(String string) {
        Date date = new Date(string);
        dateManager = new DateManager(date);
    }

    public void processMenu(String string) {
        List<Menu> menus = generateMenus(string);
        menuManager = new MenuManager(menus);
    }

    public void generateTotalPricer() {
        totalPricer = new TotalPricer(dateManager, menuManager);
    }
    
    private List<Menu> generateMenus(String string) {
        List<Menu> menus = new ArrayList<>();

        List<String> menuAndAmountList = List.of(string.split(","));
        for (String menuAndAmount : menuAndAmountList) {
            List<String> menu = List.of(menuAndAmount.split("-"));
            if (!(menu.size() == 2)) {
                throw new IllegalArgumentException();
            }
            menus.add(new Menu(menu.get(0), menu.get(1)));
        }
        return menus;
    }

}
