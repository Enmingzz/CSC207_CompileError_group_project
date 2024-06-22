package entity.schedule;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Provide the interface of CommonSchedule
 * @author CompileError group
 */

public interface Schedule {
    Time getBuyerTime();

    ArrayList<Time> getSellerTime();
}
