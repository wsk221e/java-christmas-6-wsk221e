package christmas.model;

import christmas.domain.Date;
import christmas.dto.DateDTO;

public class DateManager {
    // Fields, Constructor
    private final Date date;

    public DateManager(Date date) {
        this.date = date;
    }


    // Features
    public DateDTO getDate() {
        return date.toDTO();
    }

}
