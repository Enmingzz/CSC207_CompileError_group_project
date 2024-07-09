package interface_adapter.search_product;

import entity.user.User;
import use_case.search_product.SearchProductByNameInputBoundary;
import use_case.search_product.SearchProductByNameInputData;

public class SearchProductByNameController {

    final private SearchProductByNameInputBoundary searchProductByNameInteractor;

    public SearchProductByNameController(SearchProductByNameInputBoundary searchProductByNameInteractor) {
        this.searchProductByNameInteractor = searchProductByNameInteractor;
    }

    public void execute(User user, String productName){
        SearchProductByNameInputData searchProductByNameInputData =
                new SearchProductByNameInputData(user, productName);
        searchProductByNameInteractor.execute(searchProductByNameInputData);
    }

}
