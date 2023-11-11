package christmas.model;

import christmas.domain.Date;
import christmas.dto.DateDTO;

public class DateManager {
    private final Date date;


    public DateManager(Date date) {
        this.date = date;
    }

    public DateDTO getDate() {
        return date.toDTO();
    }

}
