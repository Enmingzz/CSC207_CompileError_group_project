package use_case.schedule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SellerSelectScheduleInputBoundary interface provides a method for executing
 * the process of selecting a schedule for a seller.
 */
public interface SellerSelectScheduleInputBoundary {
    /**
     * Executes the process of selecting a schedule for a seller.
     *
     * @param inputData the input data containing seller, product, and selected schedule time
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(SellerSelectScheduleInputData inputData) throws SQLException, IOException;
}
