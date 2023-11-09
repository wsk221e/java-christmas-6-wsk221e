package christmas.model;

import christmas.domain.Menu;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MenuManagerTest {
    @ParameterizedTest
    @MethodSource("provideMenuManagerValidationTest")
    @DisplayName("유효하지 않은 메뉴 리스트를 전달하면 IllegalStateException을 던진다.")
    void MenuManagerValidationTest(List<Menu> menus) {
        Assertions.assertThrows(IllegalStateException.class, () -> new MenuManager(menus));
    }

    private static Stream<List<Menu>> provideMenuManagerValidationTest() {
        return Stream.of(
                //총 수량이 20을 초과하는 경우
                Arrays.asList(new Menu("해산물파스타", "12"), new Menu("제로콜라", "12")),
                //음료만 주문하는 경우
                Arrays.asList(new Menu("레드와인", "5")),
                //메뉴명이 중복되는 경우
                Arrays.asList(new Menu("초코케이크", "2"), new Menu("초코케이크", "3"))
        );
    }

}
