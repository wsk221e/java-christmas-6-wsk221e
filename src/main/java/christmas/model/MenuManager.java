package christmas.model;

import static christmas.utils.validation.Validator.validateMenus;

import christmas.domain.Menu;
import christmas.dto.MenuDTO;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    // Fields, Constructor
    private final List<Menu> menus;

    public MenuManager(List<Menu> menus) {
        this.menus = menus;
        validateMenus(getMenus());
    }


    // Features
    public List<MenuDTO> getMenus() {
        List<MenuDTO> menuDtos = new ArrayList<>();
        for (Menu menu : menus) {
            menuDtos.add(menu.toDTO());
        }
        return menuDtos;
    }

}
