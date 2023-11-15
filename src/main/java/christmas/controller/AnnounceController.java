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
    // Fields
    private final OutputView announce = new OutputView();


    // Features
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


    // Internal Implements
    // 인사말과 날짜를 출력한다.
    private void displayGreetings(DateDTO date) {
        announce.displayFormatString(Templates.OUTPUT_GREETINGS_MESSAGE, date.date);
    }

    // 메뉴를 출력한다.
    private void displayMenu(List<MenuDTO> menus) {
        announce.displayString(Templates.OUTPUT_MENU_MESSAGE);
        for (MenuDTO menu : menus) {
            announce.displayFormatString(Templates.OUTPUT_INNER_FORMAT_MENU, menu.name, menu.amount);
        }
    }

    // 총 금액을 출력한다.
    private void displayTotalPrice(PriceDTO price) {
        announce.displayFormatString(Templates.OUTPUT_PRICE_TOTAL_MESSAGE, price.price);
    }

    // 조건에 따라 증정품을 출력한다.
    private void displayPresent(PriceDTO price) {
        String string = Templates.OUTPUT_PRESENT_MESSAGE.format(Templates.OUTPUT_NONE_MESSAGE);
        if (price.isChampagne) {
            String innerString = Templates.OUTPUT_INNER_FORMAT_MENU.format(Strings.PRESENT.getName(),
                    Integers.PRESENT_AMOUNT.getValue());
            string = Templates.OUTPUT_PRESENT_MESSAGE.format(innerString);
        }
        announce.displayString(string);
    }

    // 조건에 따라 혜택 내역을 출력한다.
    private void displayBenefits(DateDTO date, PriceDTO price, EventDTO event) {
        boolean benefitCondition = calculateBenefitDisplayCondition(event, price);
        announce.displayString(Templates.OUTPUT_BENEFIT_STATUS_MESSAGE);
        if (benefitCondition) {
            displayBenefitsDetails(date, price, event);
        }
        if (!benefitCondition) {
            String none = Templates.OUTPUT_NONE_MESSAGE.toString();
            announce.displayString(none);
        }

    }

    // 혜택 출력에 대한 조건을 계산한다.
    private boolean calculateBenefitDisplayCondition(EventDTO event, PriceDTO price) {
        return !(event.dDay == 0 && event.menu == 0 && event.star == 0 && !price.isChampagne);
    }

    // 상세 혜택 내역을 출력한다.
    private void displayBenefitsDetails(DateDTO date, PriceDTO price, EventDTO event) {
        displayBenefitDetailsDDay(event);
        displayBenefitDetailsWeekend(date, event);
        displayBenefitDetailsStar(event);
        displayBenefitDetailsChampagne(price);
    }

    // D-Day 할인 내역을 출력한다.
    private void displayBenefitDetailsDDay(EventDTO event) {
        if (event.dDay > 0) {
            announce.displayFormatString(Templates.OUTPUT_DISCOUNT_DDAY, event.dDay);
        }
    }

    // 주말 할인 내역을 출력한다.
    private void displayBenefitDetailsWeekend(DateDTO date, EventDTO event) {
        if (event.menu > 0) {
            String weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKDAY.format(event.menu);
            if (date.isWeekend) {
                weekDiscount = Templates.OUTPUT_DISCOUNT_WEEKEND.format(event.menu);
            }
            announce.displayString(weekDiscount);
        }
    }

    // 별표 할인 내역을 출력한다.
    private void displayBenefitDetailsStar(EventDTO event) {
        if (event.star > 0) {
            announce.displayFormatString(Templates.OUTPUT_DISCOUNT_STAR, event.star);
        }
    }

    // 샴페인 증정 내역을 출력한다.
    private void displayBenefitDetailsChampagne(PriceDTO price) {
        if (price.isChampagne) {
            announce.displayFormatString(Templates.OUTPUT_DISCOUNT_PRESENT, Integers.CHAMPAGNE_PRICE.getValue());
        }
    }

    // 총 혜택 금액을 출력한다.
    private void displayTotalBenefit(PriceDTO price) {
        announce.displayFormatString(Templates.OUTPUT_TOTAL_BENEFIT_MESSAGE, price.benefit);
    }

    // 할인이 적용된 최종 금액을 출력한다.
    private void displayFinalPrice(PriceDTO price) {
        String finalPrice = String.valueOf(price.price - price.discount);
        announce.displayFormatString(Templates.OUTPUT_PRICE_FINAL_MESSAGE, finalPrice);
    }

    // 뱃지를 출력한다.
    private void displayBadge(PriceDTO price) {
        boolean badgeCondition = !price.badge.equals("");
        if (badgeCondition) {
            announce.displayFormatString(Templates.OUTPUT_BADGE_MESSAGE, price.badge);
        }
        if (!badgeCondition) {
            announce.displayFormatString(Templates.OUTPUT_BADGE_MESSAGE, Templates.OUTPUT_NONE_MESSAGE);
        }
    }

}
