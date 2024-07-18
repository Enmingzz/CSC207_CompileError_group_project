package entity.schedule;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Provide the interface for CommonScheduleFactory.
 * Provide one method createSchedule()
 * @author CompileError group
 */

public interface ScheduleFactory {
    Schedule createSchedule(LocalDateTime buyerTime, ArrayList<LocalDateTime> sellerTime);
}
