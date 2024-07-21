package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface defining the operations for creating a new product.
 * This interface provides a method for handling the creation of a new product in the system. Implementations
 * of this interface are responsible for processing the input data and performing the necessary operations
 * to create and persist the product.
 */
public interface CreateProductInputBoundary {
    /**
     * Executes the operation to create a new product with the given input data.
     *
     * @param createProductInputData the data required to create the new product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs during the creation process
     */
    void execute(CreateProductInputData createProductInputData) throws SQLException, IOException;
}
