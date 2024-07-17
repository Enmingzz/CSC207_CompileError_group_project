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
    /**
     * Creates a new instance of {@link CommonSchedule} with the specified buyer time and seller times.
     *
     * @param buyerTime   the date and time for the buyer
     * @param sellerTime  the list of dates and times for the seller
     * @return a new {@link CommonSchedule} instance
     */

    @Override
    public Schedule createSchedule(LocalDateTime buyerTime, ArrayList<LocalDateTime> sellerTime) {
        return new CommonSchedule(buyerTime, sellerTime);
    }
}
