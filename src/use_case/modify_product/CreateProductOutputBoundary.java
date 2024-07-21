package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the boundary that handles the output of the product creation use case.
 * This interface is responsible for defining methods to present the outcome of a product creation process.
 */
public interface CreateProductOutputBoundary {

    /**
     * Prepares and presents the view for a successful product creation.
     *
     * @param createProductOutputData the data representing the result of a successful product creation
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) throws SQLException, IOException;

    /**
     * Prepares and presents the view for a failed product creation.
     *
     * @param error a string representing the error message describing the failure reason
     */
    public void prepareFailedView(String error);
}
