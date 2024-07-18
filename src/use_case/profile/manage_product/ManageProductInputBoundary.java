package use_case.profile.manage_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for managing products.
 * Provides a method to execute the action of managing a product with the given input data.
 */
public interface ManageProductInputBoundary {

    /**
     * Executes the action of managing a product.
     *
     * @param manageProductInputData the input data for managing the product
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(ManageProductInputData manageProductInputData) throws SQLException, IOException;
}
