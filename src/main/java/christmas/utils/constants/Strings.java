package christmas.utils.constants;

public enum Strings {
    DISCOUNT_WEEKEND("메인"),
    DISCOUNT_WEEKDAY("디저트"),
    MENU_ONLY_FORBIDDEN("음료"),
    PRESENT("샴페인");

    private final String name;


    Strings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
