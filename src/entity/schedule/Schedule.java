package entity.schedule;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Provide the interface of CommonSchedule
 * @author CompileError group
 */

public interface Schedule {
    LocalDateTime getBuyerTime();

    ArrayList<LocalDateTime> getSellerTime();
}
