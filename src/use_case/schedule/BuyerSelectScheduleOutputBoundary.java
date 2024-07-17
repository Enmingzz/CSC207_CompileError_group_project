package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The BuyerSelectScheduleOutputBoundary interface provides methods for preparing the
 * output view based on the result of the schedule selection process.
 */
public interface BuyerSelectScheduleOutputBoundary {
    /**
     * Prepares the successful view with the given output data.
     *
     * @param outputData the output data containing the buyer and updated product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData) throws SQLException, IOException;
    /**
     * Prepares the failed view with the given error message.
     *
     * @param error the error message to display
     */
    void prepareFailedView(String error);
}
