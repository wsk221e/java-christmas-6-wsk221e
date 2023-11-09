package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {
    @ParameterizedTest
    @CsvSource({
            "족발-2", // 유효하지 않은 메뉴 입력
            "초코케이크-0", // 유효하지 않은 수량 입력(하한 경계값)
            "초코케이크-21", // 유효하지 않은 수량 입력(상한 경곗값)
    })
    @DisplayName("유효하지 않은 값을 입력하면 IllegalArgument 에러를 발생시킨다.")
    void MenuValidationTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] parts = input.split("-");
            new Menu(parts[0], parts[1]);
        });
    }

}
