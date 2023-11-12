package christmas.controller;

import christmas.dto.DateDTO;
import christmas.dto.EventDTO;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;
import christmas.service.Receipt;
import christmas.utils.constants.Integers;
import christmas.utils.constants.Strings;
import christmas.utils.constants.Templates;
import christmas.view.OutputView;
import java.util.List;

public class AnnounceController {
    private final OutputView announce = new OutputView();


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

    public void displayGreetings(DateDTO date) {
        displayFormatString(Templates.OUTPUT_GREETINGS_MESSAGE, date.date);
    }

    public void displayMenu(List<MenuDTO> menus) {
        announce.displayString(Templates.OUTPUT_MENU_MESSAGE);
        for (MenuDTO menu : menus) {
            displayFormatString(Templates.OUTPUT_INNER_FORMAT_MENU, menu.name, menu.amount);
        }
    }

    public void displayTotalPrice(PriceDTO price) {
        displayFormatString(Templates.OUTPUT_PRICE_TOTAL_MESSAGE, price.price);
    }

    public void displayPresent(PriceDTO price) {
        String string = Templates.OUTPUT_PRESENT_MESSAGE.format(Templates.OUTPUT_NONE_MESSAGE);
        if (price.isChampagne) {
            String innerString = Templates.OUTPUT_INNER_FORMAT_MENU.format(Strings.PRESENT.getName(),
                    Integers.PRESENT_AMOUNT.getValue());
            string = Templates.OUTPUT_PRESENT_MESSAGE.format(innerString);
        }
        announce.displayString(string);
    }

    public void displayBenefits(DateDTO date, PriceDTO price, EventDTO event) {
        boolean benefitCondition = calculateBenefitDisplayCondition(event, price);
        announce.displayString(Templates.OUTPUT_BENEFIT_STATUS_MESSAGE);
        if (benefitCondition) {
            requestDisplayBenefitsDetails(date, price, event);
        }
        if (!benefitCondition) {
            String none = Templates.OUTPUT_NONE_MESSAGE.toString();
            announce.displayString(none);
        }

    }

    public void displayTotalBenefit(PriceDTO price) {
        displayFormatString(Templates.OUTPUT_TOTAL_BENEFIT_MESSAGE, price.benefit);
    }

    public void displayFinalPrice(PriceDTO price) {
        String finalPrice = String.valueOf(price.price - price.discount);
        displayFormatString(Templates.OUTPUT_PRICE_FINAL_MESSAGE, finalPrice);
    }

    public void displayBadge(PriceDTO price) {
        boolean badgeCondition = !price.badge.equals("");
        if (badgeCondition) {
            displayFormatString(Templates.OUTPUT_BADGE_MESSAGE, price.badge);
        }
        if (!badgeCondition) {
            displayFormatString(Templates.OUTPUT_BADGE_MESSAGE, Templates.OUTPUT_NONE_MESSAGE);
        }
    }


    private void displayFormatString(Templates template, Object... values) {
        String string = template.format(values);
        announce.displayString(string);
    }

    private boolean calculateBenefitDisplayCondition(EventDTO event, PriceDTO price) {
        return !(event.dDay == 0 && event.menu == 0 && event.star == 0 && !price.isChampagne);
    }

    private void requestDisplayBenefitsDetails(DateDTO date, PriceDTO price, EventDTO event) {
        displayBenefitDetailsDDay(event);
        displayBenefitDetailsWeekend(date, event);
        displayBenefitDetailsStar(event);
        displayBenefitDetailsChampagne(price);
    }

    private void displayBenefitDetailsDDay(EventDTO event) {
        if (event.dDay > 0) {
            displayFormatString(Templates.OUTPUT_DISCOUNT_DDAY, event.dDay);
        }
    }

    private void displayBenefitDetailsWeekend(DateDTO date, EventDTO event) {
        if (event.menu > 0) {
            String weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKDAY.format(event.menu);
            if (date.isWeekend) {
                weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKEND.format(event.menu);
            }
            announce.displayString(weekDiscount);
        }
    }

    private void displayBenefitDetailsStar(EventDTO event) {
        if (event.star > 0) {
            displayFormatString(Templates.OUTPUT_DISCOUNT_STAR, event.star);
        }
    }

    private void displayBenefitDetailsChampagne(PriceDTO price) {
        if (price.isChampagne) {
            displayFormatString(Templates.OUTPUT_DISCOUNT_PRESENT, Integers.CHAMPAGNE_PRICE.getValue());
        }
    }

}
