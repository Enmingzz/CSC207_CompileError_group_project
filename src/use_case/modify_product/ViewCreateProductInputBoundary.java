package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the boundary interface for handling input data related to viewing the creation of a product.
 *
 * This interface is responsible for processing the input data required to view or handle the creation of a product.
 */
public interface ViewCreateProductInputBoundary {

    /**
     * Processes the given input data related to viewing or handling the creation of a product.
     *
     * @param viewCreateProductInputData The input data required for viewing or handling the creation of a product.
     * @throws SQLException If an SQL error occurs while processing the data.
     * @throws IOException If an I/O error occurs while processing the data.
     */
    void execute(ViewCreateProductInputData viewCreateProductInputData) throws SQLException, IOException;
}
