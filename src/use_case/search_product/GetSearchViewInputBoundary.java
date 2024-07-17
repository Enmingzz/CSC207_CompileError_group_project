package use_case.search_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetSearchViewInputBoundary interface provides a method for executing
 * the process of retrieving the search page.
 */
public interface GetSearchViewInputBoundary {
    /**
     * Executes the process of retrieving the search page.
     *
     * @param getSearchViewInputData the input data containing user information.
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    void getSearchView(GetSearchViewInputData getSearchViewInputData) throws SQLException, IOException;
}
