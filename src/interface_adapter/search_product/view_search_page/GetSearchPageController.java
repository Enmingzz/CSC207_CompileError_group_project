package interface_adapter.search_product.view_search_page;

import entity.user.User;
import use_case.search_product.GetSearchViewInputBoundary;
import use_case.search_product.GetSearchViewInputData;


import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetSearchPageController class handles the request to retrieve the search page.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class GetSearchPageController {
    final GetSearchViewInputBoundary getSearchViewInputBoundary;

    /**
     * Constructs a GetSearchPageController with the specified input boundary.
     *
     * @param getSearchViewInputBoundary the input boundary to handle the search page retrieval
     */
    public GetSearchPageController(GetSearchViewInputBoundary getSearchViewInputBoundary) {
        this.getSearchViewInputBoundary = getSearchViewInputBoundary;
    }

    /**
     * Executes the process of retrieving the search page view for the given user.
     *
     * @param user the user requesting the search page
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User user) throws SQLException, IOException {
        GetSearchViewInputData getSearchViewInputData = new GetSearchViewInputData(user);
        getSearchViewInputBoundary.getSearchView(getSearchViewInputData);
    }
}
