package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface SellerSelectScheduleOutputBoundary {
    void prepareSuccessfulView(SellerSelectScheduleOutputData outputData) throws SQLException, IOException;
    void prepareFailedView(String error);
}
