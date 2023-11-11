package christmas.controller;

import christmas.dto.DateDTO;
import christmas.dto.EventDTO;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;
import christmas.service.Receipt;
import christmas.utils.constants.Integers;
import christmas.utils.constants.Strings;
import christmas.utils.constants.Templates;
import christmas.view.DisplayAnnounce;
import java.util.List;

public class AnnounceController {
    private final DisplayAnnounce announce = new DisplayAnnounce();

    public void displayResult(Receipt result) {
        DateDTO date = result.getDate();
        List<MenuDTO> menus = result.getMenus();
        PriceDTO price = result.getPrice();
        EventDTO event = price.event;

        displayGreetings(date);
        displayMenu(menus);
        displayTotalPrice(price);
        displayPresent(price);
        displayBenefits(date, price, event);
        displayTotalBenefit(price);
        displayFinalPrice(price);
        displayBadge(price);
    }


    private void displayGreetings(DateDTO date) {
        String string = Templates.OUTPUT_GREETINGS_MESSAGE.format(date.date);
        announce.displayString(string);
    }

    private void displayMenu(List<MenuDTO> menus) {
        announce.displayString(Templates.OUTPUT_MENU_MESSAGE);
        for (MenuDTO menu : menus) {
            String string = Templates.OUTPUT_INNER_FORMAT_MENU.format(menu.name, menu.amount);
            announce.displayString(string);
        }
    }

    private void displayTotalPrice(PriceDTO price) {
        String string = Templates.OUTPUT_PRICE_TOTAL_MESSAGE.format(price.price);
        announce.displayString(string);
    }

    private void displayPresent(PriceDTO price) {
        String string = Templates.OUTPUT_PRESENT_MESSAGE.format(Templates.OUTPUT_NONE_MESSAGE);
        if (price.isChampagne) {
            String innerString = Templates.OUTPUT_INNER_FORMAT_MENU.format(Strings.PRESENT.getName(),
                    Integers.PRESENT_AMOUNT.getValue());
            string = Templates.OUTPUT_PRESENT_MESSAGE.format(innerString);
        }
        announce.displayString(string);
    }

    private void displayBenefits(DateDTO date, PriceDTO price, EventDTO event) {
        boolean noneCondition = event.dDay == 0 && event.menu == 0 && event.star == 0 && !price.isChampagne;
        announce.displayString(Templates.OUTPUT_BENEFIT_STATUS_MESSAGE);
        if (noneCondition) {
            String none = Templates.OUTPUT_NONE_MESSAGE.toString();
            announce.displayString(none);
        }
        if (!noneCondition) {
            if (event.dDay > 0) {
                String dDayDiscount = Templates.OUTPUT_DISCOUNT_DDAY.format(event.dDay);
                announce.displayString(dDayDiscount);
            }
            if (event.menu > 0) {
                String weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKDAY.format(event.menu);
                if (date.isWeekend) {
                    weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKEND.format(event.menu);
                }
                announce.displayString(weekDiscount);
            }
            if (event.star > 0) {
                String starDiscount = Templates.OUTPUT_DISCOUNT_STAR.format(event.star);
                announce.displayString(starDiscount);
            }
            if (price.isChampagne) {
                String present = Templates.OUTPUT_DISCOUNT_PRESENT.format(Integers.CHAMPAGNE_PRICE.getValue());
                announce.displayString(present);
            }
        }

    }

    private void displayTotalBenefit(PriceDTO price) {
        String string = Templates.OUTPUT_TOTAL_BENEFIT_MESSAGE.format(price.benefit);
        announce.displayString(string);
    }

    private void displayFinalPrice(PriceDTO price) {
        String finalPrice = String.valueOf(price.price - price.discount);
        String string = Templates.OUTPUT_PRICE_FINAL_MESSAGE.format(finalPrice);
        announce.displayString(string);
    }

    private void displayBadge(PriceDTO price) {
        String string = Templates.OUTPUT_BADGE_MESSAGE.format(price.badge);
        announce.displayString(string);
    }

}
