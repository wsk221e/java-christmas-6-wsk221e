package christmas.domain;

import static christmas.utils.constants.Integers.DATE_RANGE_MAX;
import static christmas.utils.constants.Integers.DATE_RANGE_MIN;
import static christmas.utils.constants.Integers.D_DAY;

import christmas.utils.Parser;
import java.util.List;

public class Date {
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

    public int getDDay() {
        return D_DAY.getValue() - date;
    }

    private void validate(int date) {
        if (date < DATE_RANGE_MIN.getValue() || date > DATE_RANGE_MAX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

}
