package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the interface for presenting the output of the use case where a user views or handles
 * the modification of a product.
 *
 * This interface includes methods to handle the successful and failed presentation of the output
 * data associated with the modification process.
 */
public interface ViewModifyProductOutputBoundary {

    /**
     * Prepares and displays the view for a successful product modification request.
     *
     * This method is called when the modification of the product is successfully processed.
     * It provides the output data necessary to present the result of the modification to the user.
     *
     * @param viewModifyProductOutputData The data containing the results of the product modification request.
     * @throws SQLException If there is an error accessing the database.
     * @throws IOException If there is an error handling I/O operations.
     */
    void prepareSuccessfulView(ViewModifyProductOutputData viewModifyProductOutputData) throws SQLException, IOException;
}
