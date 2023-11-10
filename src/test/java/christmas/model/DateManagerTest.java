package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DateManagerTest {

    @ParameterizedTest
    @MethodSource("provideDatesForDiscountTest")
    @DisplayName("D-Day가 다가올수록 할인 금액이 일정한 금액씩 증가한다.")
    void testGetDDayDiscount(Date date, int expectedDiscount) {
        DateManager dateManager = new DateManager(date);
        int actualDiscount = dateManager.getDDayDiscount();
        assertEquals(expectedDiscount, actualDiscount);
    }

    private static Stream<Arguments> provideDatesForDiscountTest() {
        return Stream.of(
                Arguments.of(new Date("1"), 1000),
                Arguments.of(new Date("25"), 3400),
                Arguments.of(new Date("26"), 0)
        );
    }

}
