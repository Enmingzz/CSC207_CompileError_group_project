package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetBuyerSchedulePageInputBoundary interface provides a method for executing
 * the process of retrieving the schedule page for a buyer.
 */
public interface GetBuyerSchedulePageInputBoundary {
    /**
     * Executes the process of retrieving the schedule page for a buyer.
     *
     * @param getBuyerSchedulePageInputData the input data containing buyer and product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(GetBuyerSchedulePageInputData getBuyerSchedulePageInputData) throws SQLException, IOException;
}
