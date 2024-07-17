package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SearchProductByTagInputBoundary interface provides a method for executing
 * the process of searching for products by tag.
 */
public interface SearchProductByTagInputBoundary {
    /**
     * Executes the process of searching for products by tag.
     *
     * @param inputData the input data containing the search tag
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void execute(SearchProductByTagInputData inputData) throws SQLException, IOException;
}
