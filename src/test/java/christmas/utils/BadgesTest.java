package christmas.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Badges;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BadgesTest {
    @ParameterizedTest
    @CsvSource({
            "4999, ''",
            "5000, '별'",
            "9999, '별'",
            "10000, '트리'",
            "19999, '트리'",
            "20000, '산타'",
            "100000, '산타'"
    })
    @DisplayName("혜택 금액에 따라 올바른 배지를 부여해야 한다.")
    void getBadgeByBenefitTest(int benefit, String expectedBadge) {
        String actualBadge = Badges.getBadgeByBenefit(benefit);
        assertEquals(expectedBadge, actualBadge);
    }

}
