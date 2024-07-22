package use_case.rate_product;

import use_case.modify_product.ChangeProductOutputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the output boundary of the rate product use case.
 *
 * This interface defines methods for preparing the view based on the outcome of the
 * rate product use case. It provides methods for handling both successful and failed
 * outcomes.
 */
public interface RateProductOutputBoundary {

    /**
     * Prepares the view for a successful rating of a product.
     *
     * This method is called when the rating process is successful. It allows the
     * implementation to handle the successful outcome, typically by updating the UI
     * or notifying the user of the success.
     *
     * @param rateProductOutputData The data containing information about the product
     *                              and user involved in the rating process.
     * @throws SQLException If a database access error occurs.
     * @throws IOException  If an I/O error occurs.
     */
    void prepareSuccessfulView(RateProductOutputData rateProductOutputData) throws SQLException, IOException;

    /**
     * Prepares the view for a failed rating of a product.
     *
     * This method is called when the rating process fails. It allows the implementation
     * to handle the failure, typically by showing an error message or notifying the user
     * of the failure reason.
     *
     * @param error A string describing the error that occurred during the rating process.
     * @throws SQLException If a database access error occurs.
     * @throws IOException  If an I/O error occurs.
     */
    void prepareFailedView(String error) throws SQLException, IOException;
}
