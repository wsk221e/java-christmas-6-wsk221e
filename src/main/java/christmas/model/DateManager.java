package christmas.model;

import christmas.domain.Date;
import java.util.List;

public class DateManager {
    private final List<Integer> weekendDate = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private final List<Integer> staredDate = List.of(3, 10, 17, 24, 25, 31);
    private final Date date;


    public DateManager(Date date) {
        this.date = date;
    }


    public Boolean isWeekend() {
        Boolean isWeekend = date.isIncluded(weekendDate);
        return isWeekend;
    }

    public Boolean isStared() {
        Boolean isStared = date.isIncluded(staredDate);
        return isStared;
    }

}
