package christmas.utils.constants;

public enum Templates {
    // Values, Fields, Constructor
    INPUT_DATE_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
    INPUT_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n"),
    OUTPUT_PREVIEW_MESSAGE("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER_MESSAGE("<주문 메뉴>\n%s\n"),
    OUTPUT_INNER_FORMAT_AMOUNT("%s %s개"),
    OUTPUT_PRICE_TOTAL_MESSAGE("<할인 전 총주문 금액>\n%s원"),
    OUTPUT_PRESENT_MESSAGE("<증정 메뉴>\n%s"),
    OUTPUT_EVENT_STATUS_MESSAGE("<혜택 내역>\n%s"),
    OUTPUT_INNER_FORMAT_PRICE("%s: -%s원"),
    OUTPUT_TOTAL_BENEFIT_MESSAGE("<총혜택 금액>\n-%s원"),
    OUTPUT_PRICE_FINAL_MESSAGE("<할인 후 예상 결제 금액>\n%s원"),
    OUTPUT_BADGE_MESSAGE("<12월 이벤트 배지>\n%s"),
    ERROR_DATE_MESSAEGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.\n"),
    ERROR_MENU_MESSAEGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n");

    private final String message;

    Templates(String message) {
        this.message = message;
    }


    // Features
    @Override
    public String toString() {
        return message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }

}
