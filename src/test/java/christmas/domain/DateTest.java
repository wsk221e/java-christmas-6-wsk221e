package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "d", "0", "32"})
    @DisplayName("유효하지 않은 날짜를 입력하면 IllegalArgument 에러를 발생시킨다.")
    void invalidDataTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Date(input);
        });
    }

}

