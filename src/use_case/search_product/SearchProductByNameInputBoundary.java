package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SearchProductByNameInputBoundary interface provides a method for executing
 * the process of searching for products by name.
 */
public interface SearchProductByNameInputBoundary {

    /**
     * Executes the process of searching for products by name.
     *
     * @param inputData the input data containing the user information and search query
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(SearchProductByNameInputData inputData) throws SQLException, IOException;
}
