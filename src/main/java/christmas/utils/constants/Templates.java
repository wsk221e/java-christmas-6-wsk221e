package christmas.utils.constants;

import java.text.NumberFormat;
import java.util.Locale;

public enum Templates {
    // Values, Fields, Constructor
    INPUT_DATE_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
    INPUT_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n"),
    OUTPUT_GREETINGS_MESSAGE("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    OUTPUT_MENU_MESSAGE("\n<주문 메뉴>\n"),
    OUTPUT_INNER_FORMAT_MENU("%s %s개\n"),
    OUTPUT_PRICE_TOTAL_MESSAGE("\n<할인 전 총주문 금액>\n%s원\n"),
    OUTPUT_PRESENT_MESSAGE("\n<증정 메뉴>\n%s"),
    OUTPUT_BENEFIT_STATUS_MESSAGE("\n<혜택 내역>\n"),
    OUTPUT_INNER_FORMAT_PRICE("%s: -%s원\n"),
    OUTPUT_DISCOUNT_DDAY("크리스마스 디데이 할인: -%s원\n"),
    OUTPUT_DISCOUNT_WEEKDAY("평일 할인: -%s원\n"),
    OUTPUT_DISCOUNT_WEEKEND("주말 할인: -%s원\n"),
    OUTPUT_DISCOUNT_STAR("특별 할인: -%s원\n"),
    OUTPUT_DISCOUNT_PRESENT("증정 이벤트: -%s원\n"),
    OUTPUT_TOTAL_BENEFIT_MESSAGE("\n<총혜택 금액>\n-%s원\n"),
    OUTPUT_PRICE_FINAL_MESSAGE("\n<할인 후 예상 결제 금액>\n%s원\n"),
    OUTPUT_BADGE_MESSAGE("\n<12월 이벤트 배지>\n%s"),
    OUTPUT_NONE_MESSAGE("없음\n"),
    ERROR_DATE_MESSAEGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_MENU_MESSAEGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    Templates(String message) {
        this.message = message;
    }


    // Features
    @Override
    public String toString() {
        return message.replace("\n", System.lineSeparator());
    }

    public String format(Object... args) {
        Object[] formattedArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = tryParseInt(args[i]);
            boolean condition = args[i] instanceof Integer;
            if (condition) {
                formattedArgs[i] = NumberFormat.getNumberInstance(Locale.US).format(args[i]);
            }
            if (!condition) {
                formattedArgs[i] = args[i];
            }
        }
        return String.format(this.toString(), formattedArgs);
    }

    private Object tryParseInt(Object arg) {
        String string = arg.toString();
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            return arg;
        }
    }

}
