package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The BuyerSelectScheduleInputBoundary interface provides a method for executing
 * the process of selecting a schedule for a buyer.
 */
public interface BuyerSelectScheduleInputBoundary {

    /**
     * Executes the process of selecting a schedule for a buyer.
     *
     * @param inputData the input data containing buyer, product, and selected schedule time
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(BuyerSelectScheduleInputData inputData) throws SQLException, IOException;
}
