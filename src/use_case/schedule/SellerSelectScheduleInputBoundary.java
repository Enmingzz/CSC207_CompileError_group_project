package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface SellerSelectScheduleInputBoundary {
    void execute(SellerSelectScheduleInputData inputData) throws SQLException, IOException;
}
