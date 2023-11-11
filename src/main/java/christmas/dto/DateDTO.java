package christmas.dto;

public class DateDTO {
    public final String discountCategory;
    public final boolean isStared;
    public final int dDay;

    public DateDTO(String discountCategory, boolean isStared, int dDay) {
        this.discountCategory = discountCategory;
        this.isStared = isStared;
        this.dDay = dDay;
    }

}
