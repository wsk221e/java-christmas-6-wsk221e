package christmas.domain;

import static christmas.utils.constants.Integers.D_DAY;
import static christmas.utils.constants.Strings.DISCOUNT_WEEKDAY;
import static christmas.utils.constants.Strings.DISCOUNT_WEEKEND;
import static christmas.utils.validation.Validator.validateDate;

import christmas.dto.DateDTO;
import christmas.utils.Utils;
import java.util.List;

public class Date {
    // Constants, Fields, Constructor
    private final List<Integer> weekendDate = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private final List<Integer> staredDate = List.of(3, 10, 17, 24, 25, 31);
    private final int date;

    public Date(String string) {
        int date = Utils.parseInt(string);
        validateDate(date);
        this.date = date;
    }


    // Features
    public DateDTO toDTO() {
        return new DateDTO(getDiscountCategory(), isWeekend(), isStared(), date, getDDay());
    }


    // Internal Implements
    private String getDiscountCategory() {
        if (weekendDate.contains(date)) {
            return DISCOUNT_WEEKEND.getName();
        }
        return DISCOUNT_WEEKDAY.getName();
    }

    private boolean isWeekend() {
        return weekendDate.contains(date);
    }

    private boolean isStared() {
        return staredDate.contains(date);
    }

    private int getDDay() {
        return D_DAY.getValue() - date;
    }

}
