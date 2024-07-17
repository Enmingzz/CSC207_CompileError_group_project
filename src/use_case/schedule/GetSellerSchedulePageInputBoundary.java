package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetSellerSchedulePageInputBoundary interface provides a method for executing
 * the process of retrieving the schedule page for a seller.
 */
public interface GetSellerSchedulePageInputBoundary {

    /**
     * Executes the process of retrieving the schedule page for a seller.
     *
     * @param getSellerSchedulePageInputData the input data containing seller and product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(GetSellerSchedulePageInputData getSellerSchedulePageInputData) throws SQLException, IOException;

}
