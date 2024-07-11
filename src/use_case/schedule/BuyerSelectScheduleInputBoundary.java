package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface BuyerSelectScheduleInputBoundary {
    void execute(BuyerSelectScheduleInputData inputData) throws SQLException, IOException;
}
