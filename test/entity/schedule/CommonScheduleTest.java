package entity.schedule;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonScheduleTest {

    private Schedule commonSchedule;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    @BeforeEach
    void setUp() {
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBuyerTime() {
        assertEquals(time, commonSchedule.getBuyerTime());
    }

    @Test
    void getSellerTime() {
        assertEquals(localDateTimeList, commonSchedule.getSellerTime());
    }

}