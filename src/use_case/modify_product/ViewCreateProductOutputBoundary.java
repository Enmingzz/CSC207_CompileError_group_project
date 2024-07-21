package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the output boundary for viewing or handling the creation of a product.
 *
 * This interface provides a method for preparing a successful view of the product creation process.
 */
public interface ViewCreateProductOutputBoundary {

    /**
     * Prepares the view with the output data for a successful product creation or viewing process.
     *
     * @param viewCreateProductOutputData The data to be used for preparing the successful view.
     * @throws SQLException If a database access error occurs.
     * @throws IOException If an I/O error occurs.
     */
    void prepareSuccessfulView(ViewCreateProductOutputData viewCreateProductOutputData) throws SQLException, IOException;
}
