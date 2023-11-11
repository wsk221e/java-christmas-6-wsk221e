package christmas.domain;

import static christmas.utils.constants.Integers.CHAMPAGNE_CONDITION;
import static christmas.utils.constants.Integers.DISCOUNT_DDAY_MAX;
import static christmas.utils.constants.Integers.DISCOUNT_DDAY_MULTIPLIER;
import static christmas.utils.constants.Integers.DISCOUNT_MENU;
import static christmas.utils.constants.Integers.DISCOUNT_STARDAY;

import christmas.domain.enums.Badges;
import christmas.dto.DateDTO;
import christmas.dto.EventDTO;
import christmas.dto.MenuDTO;
import java.util.List;

public class Event {
    private final int dDayDiscount, menuDiscount, starDiscount;
    private final boolean champagneEvent;
    private final String badge;

    public Event(DateDTO date, List<MenuDTO> menus) {
        this.menuDiscount = calculateMenuDistount(date, menus);
        this.dDayDiscount = calculateDDayDiscount(date);
        this.starDiscount = calculateStarDiscount(date);
        int benefit = menuDiscount + dDayDiscount + starDiscount;

        this.champagneEvent = isChampagneEvent(benefit);
        this.badge = getBadge(benefit);
    }


    public EventDTO toDTO() {
        return new EventDTO(dDayDiscount, menuDiscount, starDiscount, champagneEvent, badge);
    }


    private int calculateMenuDistount(DateDTO date, List<MenuDTO> menus) {
        int discount = 0;
        for (MenuDTO menu : menus) {
            boolean discountCondition = date.discountCategory.contains(menu.category);
            if (discountCondition) {
                discount += DISCOUNT_MENU.getValue();
            }
        }
        return discount;
    }

    private int calculateDDayDiscount(DateDTO date) {
        int discount = 0;
        int dDay = date.dDay;
        if (dDay >= 0) {
            discount = DISCOUNT_DDAY_MAX.getValue() - DISCOUNT_DDAY_MULTIPLIER.getValue() * dDay;
        }
        return discount;
    }

    private int calculateStarDiscount(DateDTO date) {
        int discount = 0;
        if (date.isStared) {
            discount += DISCOUNT_STARDAY.getValue();
        }
        return discount;
    }

    private boolean isChampagneEvent(int benefit) {
        return benefit >= CHAMPAGNE_CONDITION.getValue();
    }

    private String getBadge(int benefit) {
        return Badges.getBadgeByBenefit(benefit);
    }

}
