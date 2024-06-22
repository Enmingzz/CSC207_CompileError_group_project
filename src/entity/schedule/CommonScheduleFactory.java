package entity.schedule;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Implements createSchedule()
 * Return an instance of CommonSchedule with upcasting to the schedule
 * @author CompileError group
 */

public class CommonScheduleFactory implements ScheduleFactory {
    public Schedule createSchedule(Time buyerTime, ArrayList<Time> sellerTime) {
        return new CommonSchedule(buyerTime, sellerTime);
    }
}
