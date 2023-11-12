package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.model.DateManager;
import christmas.model.MenuManager;
import christmas.service.Planner;
import christmas.utils.Utils;
import java.util.List;

public class Initializer {
    // Fields
    private DateManager dateManager;
    private MenuManager menuManager;


    // Features
    public void processDate(String string) {
        Date date = new Date(string);
        dateManager = new DateManager(date);
    }

    public void processMenu(String string) {
        List<Menu> menus = Utils.parseMenus(string);
        menuManager = new MenuManager(menus);
    }

    public Planner generatePlanner() {
        return new Planner(dateManager, menuManager);
    }

}
