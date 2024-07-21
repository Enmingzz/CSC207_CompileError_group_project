package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the input boundary for the use case of viewing or handling modifications to a product.
 *
 * This interface is responsible for executing the use case related to viewing or managing the process of modifying
 * a product, given the necessary information about the user and the product to be modified.
 */
public interface ViewModifyProductInputBoundary {

    /**
     * Executes the use case to view or handle the modification of a product.
     *
     * @param viewModifyProductInputData The input data required for the modification process,
     *                                   including information about the user and the product to be modified.
     * @throws SQLException If a database access error occurs.
     * @throws IOException  If an I/O error occurs while processing the request.
     */
    void execute(ViewModifyProductInputData viewModifyProductInputData) throws SQLException, IOException;
}
