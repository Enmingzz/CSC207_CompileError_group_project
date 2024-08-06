package interface_adapter.search_product.search;

import entity.user.User;
import use_case.search_product.SearchProductByNameInputBoundary;
import use_case.search_product.SearchProductByNameInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SearchProductByNameController class handles the request to search for products by name.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class SearchProductByNameController {

    final private SearchProductByNameInputBoundary searchProductByNameInteractor;

    /**
     * Constructs a SearchProductByNameController with the specified interactor.
     *
     * @param searchProductByNameInteractor the interactor to handle the search product by name use case
     */
    public SearchProductByNameController(SearchProductByNameInputBoundary searchProductByNameInteractor) {
        this.searchProductByNameInteractor = searchProductByNameInteractor;
    }

    /**
     * Executes the process of searching for products by name for the given user.
     *
     * @param user the user performing the search
     * @param productName the name of the product to search for
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user, String productName) throws SQLException, IOException {
        SearchProductByNameInputData searchProductByNameInputData =
                new SearchProductByNameInputData(user, productName);
        searchProductByNameInteractor.execute(searchProductByNameInputData);
    }

}
