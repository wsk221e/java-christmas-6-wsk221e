package christmas.dto;

public class DateDTO {
    public final String discountCategory;
    public final boolean isWeekend, isStared;
    public final int date, dDay;

    public DateDTO(String discountCategory, boolean isWeekend, boolean isStared, int date, int dDay) {
        this.discountCategory = discountCategory;
        this.isWeekend = isWeekend;
        this.isStared = isStared;
        this.date = date;
        this.dDay = dDay;
    }

}
