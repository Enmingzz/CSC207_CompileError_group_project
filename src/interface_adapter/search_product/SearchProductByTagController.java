package interface_adapter.search_product;

import entity.user.User;
import use_case.search_product.SearchProductByTagInputBoundary;
import use_case.search_product.SearchProductByTagInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SearchProductByTagController class handles the request to search for products by tag.
 */
public class SearchProductByTagController {
    private final SearchProductByTagInputBoundary searchProductByTagInputBoundary;

    /**
     * Constructs a SearchProductByTagController with the specified input boundary.
     *
     * @param searchProductByTagInputBoundary the input boundary to handle the search product by tag use case
     */
    public SearchProductByTagController(SearchProductByTagInputBoundary searchProductByTagInputBoundary) {
        this.searchProductByTagInputBoundary = searchProductByTagInputBoundary;
    }

    /**
     * Executes the process of searching for products by tag for the given user.
     *
     * @param user the user performing the search
     * @param tag the tag to search for
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user, String tag)  throws SQLException, IOException {
        SearchProductByTagInputData inputData = new SearchProductByTagInputData(user, tag);
        searchProductByTagInputBoundary.execute(inputData);
    }
}
