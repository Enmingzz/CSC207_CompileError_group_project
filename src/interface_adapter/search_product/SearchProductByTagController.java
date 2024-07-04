package interface_adapter.search_product;

import entity.user.User;
import use_case.product_search.SearchProductByTagInputBoundary;
import use_case.product_search.SearchProductByTagInputData;

public class SearchProductByTagController {
    private final SearchProductByTagInputBoundary searchProductByTagInputBoundary;

    public SearchProductByTagController(SearchProductByTagInputBoundary searchProductByTagInputBoundary) {
        this.searchProductByTagInputBoundary = searchProductByTagInputBoundary;
    }

    public void searchProductByTag(User user, String tag) {
        SearchProductByTagInputData inputData = new SearchProductByTagInputData(user, tag);
        searchProductByTagInputBoundary.execute(inputData);
    }
}
