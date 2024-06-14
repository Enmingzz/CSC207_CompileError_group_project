package entity;

import java.sql.Time;
import java.util.ArrayList;

public class CommonScheduleFactor implements ScheduleFactory {
    public Schedule createSchedule(Time buyerTime, ArrayList<Time> sellerTime) {
        return new CommonSchedule(buyerTime, sellerTime);
    }
}