package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface GetBuyerSchedulePageInputBoundary {
    void execute(GetBuyerSchedulePageInputData getBuyerSchedulePageInputData) throws SQLException, IOException;
}
