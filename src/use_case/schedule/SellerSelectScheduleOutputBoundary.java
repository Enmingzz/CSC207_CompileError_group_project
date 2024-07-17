package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SellerSelectScheduleOutputBoundary interface provides methods for preparing the
 * output view based on the result of the schedule selection process for a seller.
 */
public interface SellerSelectScheduleOutputBoundary {
    /**
     * Prepares the successful view with the given output data.
     *
     * @param outputData the output data containing the seller and updated product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void prepareSuccessfulView(SellerSelectScheduleOutputData outputData) throws SQLException, IOException;
    /**
     * Prepares the failed view with the given error message.
     *
     * @param error the error message to display
     */
    void prepareFailedView(String error);
}
