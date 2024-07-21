package use_case.rate_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the input boundary of the rate product use case.
 *
 * This interface defines the contract for executing the rate product use case,
 * which involves processing the user's rating for a product.
 */
public interface RateProductInputBoundary {

    /**
     * Executes the rate product use case with the provided input data.
     *
     * This method processes the user's rating for a product and handles any necessary
     * interactions with the underlying data storage or business logic.
     *
     * @param rateProductInputData The input data for the rate product use case, including
     *                             the user's rating and the product being rated.
     * @throws SQLException If a database access error occurs during the execution.
     * @throws IOException If an I/O error occurs during the execution.
     */
    void execute(RateProductInputData rateProductInputData) throws SQLException, IOException;
}
