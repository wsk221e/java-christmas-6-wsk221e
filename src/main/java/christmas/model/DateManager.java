package christmas.model;

import christmas.domain.Date;
import java.util.List;

public class DateManager {
    private final List<Integer> weekendDate = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private final List<Integer> staredDate = List.of(3, 10, 17, 24, 25, 31);
    private final String weekendDiscount = "메인";
    private final String weekdayDiscount = "디저트";
    private final int DISCOUNT_DDAY_MAX = 3400;
    private final int DISCOUNT_DDAY_MULTIPLIER = 100;

    private final Date date;


    public DateManager(Date date) {
        this.date = date;
    }


    public String getWeekendDiscount() {
        if (date.isIncluded(weekendDate)) {
            return weekendDiscount;
        }
        return weekdayDiscount;
    }

    public Boolean isStared() {
        Boolean isStared = date.isIncluded(staredDate);
        return isStared;
    }

    public int getDDayDiscount() {
        int discount = 0;
        int dDay = date.getDDay();
        if (dDay >= 0) {
            discount = DISCOUNT_DDAY_MAX - DISCOUNT_DDAY_MULTIPLIER * dDay;
        }
        return discount;
    }

}
