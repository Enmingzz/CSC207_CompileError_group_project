package entity.schedule;

import java.sql.Time;
import java.util.ArrayList;

public class CommonScheduleFactory implements ScheduleFactory {
    public Schedule createSchedule(Time buyerTime, ArrayList<Time> sellerTime) {
        return new CommonSchedule(buyerTime, sellerTime);
    }
}
