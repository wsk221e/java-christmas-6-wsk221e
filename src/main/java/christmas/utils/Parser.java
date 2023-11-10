package christmas.utils;

public class Parser {
    public static int parseInt(String string) {
        int date;
        try {
            date = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return date;
    }

}
