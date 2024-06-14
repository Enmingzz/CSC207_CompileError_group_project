package entity;

import java.sql.Time;
import java.util.ArrayList;

public interface ScheduleFactory {
    Schedule createSchedule(Time buyerTime, ArrayList<Time> sellerTime);
}
