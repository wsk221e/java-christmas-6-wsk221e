package christmas.domain;

import christmas.utils.Parser;
import java.util.List;

public class Date {
    private final int DATE_RANGE_MIN = 1;
    private final int DATE_RANGE_MAX = 31;
    private final int date;

    public Date(String string) {
        int date = Parser.parseInt(string);
        validate(date);
        this.date = date;
    }


    public Boolean isIncluded(List<Integer> dateList) {
        if (dateList.contains(date)) {
            return true;
        }
        return false;
    }

    private void validate(int date) {
        if (date < DATE_RANGE_MIN || date > DATE_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

}
