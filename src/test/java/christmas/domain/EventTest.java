package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.dto.EventDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventTest {

    @ParameterizedTest
    @CsvSource({
            "119999, false",
            "120000, true"
    })
    @DisplayName("입력받은 구매금액이 일정액 이상이면 사은품을 증정도록 상태를 변경한다.")
    void updateChampagneEventTest(int boughtAmount, boolean expectedEventStatus) {
        Event event = new Event();
        event.updateChampagneEvent(boughtAmount);
        EventDTO eventDto = event.toDTO();
        assertEquals(expectedEventStatus, eventDto.isChampagneEvent());
    }

}
