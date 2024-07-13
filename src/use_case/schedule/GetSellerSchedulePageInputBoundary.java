package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

public interface GetSellerSchedulePageInputBoundary {
    void execute(GetSellerSchedulePageInputData getSellerSchedulePageInputData) throws SQLException, IOException;

}
