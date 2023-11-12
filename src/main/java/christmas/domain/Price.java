package christmas.domain;

import christmas.domain.enums.Badges;
import christmas.dto.PriceDTO;
import christmas.utils.constants.Integers;

public class Price {
    // Fields, Constructor
    private final int price, discount, benefit;
    private final Event event;
    private final boolean isChampagne;
    private final String badge;

    public Price(int price, Event event) {
        this.price = price;
        this.event = event;
        this.discount = calculateTotalDiscount();
        this.isChampagne = event.isChampagne(price);
        this.benefit = calculateTotalBenefit();
        this.badge = getBadge(benefit);
    }


    // Features
    public PriceDTO toDTO() {
        return new PriceDTO(price, discount, benefit, event.toDTO(), isChampagne, badge);
    }


    // Internal Implements
    private int calculateTotalDiscount() {
        int discount = event.getTotalBenefit();
        return discount;
    }

    private int calculateTotalBenefit() {
        int benefit = discount;
        if (isChampagne) {
            benefit += Integers.CHAMPAGNE_PRICE.getValue();
        }
        return benefit;
    }

    private String getBadge(int discount) {
        if (isChampagne) {
            discount += Integers.CHAMPAGNE_PRICE.getValue();
        }
        return Badges.getBadgeByBenefit(discount);
    }

}
