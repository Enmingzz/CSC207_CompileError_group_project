package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface BuyerSelectScheduleOutputBoundary {
    void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) throws SQLException, IOException;
    void prepareFailedView(String error);
}
