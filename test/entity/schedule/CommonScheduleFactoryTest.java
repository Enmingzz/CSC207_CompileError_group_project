package entity.schedule;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonScheduleFactoryTest {

    private Schedule commonSchedule;
    private ScheduleFactory commonScheduleFactory;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    @BeforeEach
    void setUp() {
        commonScheduleFactory = new CommonScheduleFactory();
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSchedule() {
        Schedule newCommonSchedule = commonScheduleFactory.createSchedule(time,
                localDateTimeList);
        assertEquals(commonSchedule, newCommonSchedule);
    }

}