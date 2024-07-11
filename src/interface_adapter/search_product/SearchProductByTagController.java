package interface_adapter.search_product;

import entity.user.User;
import use_case.search_product.SearchProductByTagInputBoundary;
import use_case.search_product.SearchProductByTagInputData;

import java.io.IOException;
import java.sql.SQLException;

public class SearchProductByTagController {
    private final SearchProductByTagInputBoundary searchProductByTagInputBoundary;

    public SearchProductByTagController(SearchProductByTagInputBoundary searchProductByTagInputBoundary) {
        this.searchProductByTagInputBoundary = searchProductByTagInputBoundary;
    }

    public void execute(User user, String tag)  throws SQLException, IOException {
        SearchProductByTagInputData inputData = new SearchProductByTagInputData(user, tag);
        searchProductByTagInputBoundary.execute(inputData);
    }
}
