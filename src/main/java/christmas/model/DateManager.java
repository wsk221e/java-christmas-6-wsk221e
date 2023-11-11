package christmas.model;

import static christmas.utils.constants.Integers.DISCOUNT_DDAY_MAX;
import static christmas.utils.constants.Integers.DISCOUNT_DDAY_MULTIPLIER;
import static christmas.utils.constants.Strings.DISCOUNT_WEEKDAY;
import static christmas.utils.constants.Strings.DISCOUNT_WEEKEND;

import christmas.domain.Date;
import java.util.List;

public class DateManager {
    private final List<Integer> weekendDate = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private final List<Integer> staredDate = List.of(3, 10, 17, 24, 25, 31);
    private final Date date;


    public DateManager(Date date) {
        this.date = date;
    }

    public int getDate() {
        String value = this.date.toString();
        int date = Integer.parseInt(value);
        return date;
    }

    public String getWeekendDiscount() {
        if (date.isIncluded(weekendDate)) {
            return DISCOUNT_WEEKEND.getName();
        }
        return DISCOUNT_WEEKDAY.getName();
    }

    public Boolean isStared() {
        Boolean isStared = date.isIncluded(staredDate);
        return isStared;
    }

    public int getDDayDiscount() {
        int discount = 0;
        int dDay = date.getDDay();
        if (dDay >= 0) {
            discount = DISCOUNT_DDAY_MAX.getValue() - DISCOUNT_DDAY_MULTIPLIER.getValue() * dDay;
        }
        return discount;
    }

}
