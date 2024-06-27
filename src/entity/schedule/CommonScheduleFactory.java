package entity.schedule;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Implements createSchedule()
 * Return an instance of CommonSchedule with upcasting to the schedule
 * @author CompileError group
 */

public class CommonScheduleFactory implements ScheduleFactory {
    public Schedule createSchedule(LocalDateTime buyerTime, ArrayList<LocalDateTime> sellerTime) {
        return new CommonSchedule(buyerTime, sellerTime);
    }
}
