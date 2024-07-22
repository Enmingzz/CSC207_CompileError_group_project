package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the input boundary of the delete product use case.
 * This interface defines the method for executing the product deletion process.
 */
public interface DeleteProductInputBoundary {

    /**
     * Executes the product deletion process based on the provided input data.
     *
     * @param deleteProductInputData the data needed to perform the product deletion
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(DeleteProductInputData deleteProductInputData) throws SQLException, IOException;
}
