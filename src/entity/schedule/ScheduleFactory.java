package entity.schedule;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Provide the interface for CommonSchedule.
 * Provide one method createSchedule()
 * @author CompileError group
 */

public interface ScheduleFactory {
    Schedule createSchedule(Time buyerTime, ArrayList<Time> sellerTime);
}
