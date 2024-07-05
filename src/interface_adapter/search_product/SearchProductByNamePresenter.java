package interface_adapter.search_product;

import interface_adapter.ViewManagerModel;
import use_case.product_search.SearchProductByNameOutputBoundary;
import use_case.product_search.SearchProductByNameOutputData;
import view.product_search.SearchByNameView;

public class SearchProductByNamePresenter implements SearchProductByNameOutputBoundary{

    final private ViewManagerModel viewManagerModel;
    final private SearchProductByNameViewModel searchProductByNameViewModel;

    public SearchProductByNamePresenter(ViewManagerModel viewManagerModel,
                                        SearchProductByNameViewModel searchProductByNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchProductByNameViewModel = searchProductByNameViewModel;
    }


    public void prepareSuccessfulView(SearchProductByNameOutputData searchProductByNameOutputData) {
        searchProductByNameViewModel.setProducts(searchProductByNameOutputData.getProducts());
    }
}
