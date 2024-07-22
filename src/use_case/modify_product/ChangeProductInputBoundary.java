package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the input boundary of the use case that changes product details.
 * <p>
 * This interface defines the contract for handling the input data and executing the necessary operations to
 * modify product details. Implementations are responsible for processing the input and interacting with the
 * necessary components to effect the changes.
 * </p>
 */
public interface ChangeProductInputBoundary {

    /**
     * Executes the operation to change product details based on the provided input data.
     * <p>
     * This method processes the input data, performs the required changes to the product details, and handles
     * any interactions with data sources or other components as needed.
     * </p>
     *
     * @param changeProductInputData the input data containing the details to be changed
     * @throws SQLException if an error occurs while accessing or updating the database
     * @throws IOException if an error occurs while processing input or interacting with external resources
     */
    void execute(ChangeProductInputData changeProductInputData) throws SQLException, IOException;
}
