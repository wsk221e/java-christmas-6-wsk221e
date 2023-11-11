package christmas.dto;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;

public class MenusDTO {
    private final List<String> menus;
    private final List<Integer> amounts;

    public MenusDTO(List<Menu> menus) {
        this.menus = calculateMenus(menus);
        this.amounts = calculateAmounts(menus);
    }

    public List<String> getMenus() {
        return menus;
    }

    public List<Integer> getAmounts() {
        return amounts;
    }


    private List<String> calculateMenus(List<Menu> menus) {
        List<String> tmpMenus = new ArrayList<>();
        for (Menu menu : menus) {
            String name = menu.getName();
            tmpMenus.add(name);
        }
        return tmpMenus;
    }

    private List<Integer> calculateAmounts(List<Menu> menus) {
        List<Integer> tmpAmounts = new ArrayList<>();
        for (Menu menu : menus) {
            int amount = menu.getAmount();
            tmpAmounts.add(amount);
        }
        return tmpAmounts;
    }

}
