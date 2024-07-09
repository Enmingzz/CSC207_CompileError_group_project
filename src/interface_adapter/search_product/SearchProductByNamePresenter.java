package interface_adapter.search_product;

import interface_adapter.ViewManagerModel;
import use_case.product_search.SearchProductByNameOutputBoundary;
import use_case.product_search.SearchProductByNameOutputData;
import use_case.search_product.SearchProductByNameOutputBoundary;
import use_case.search_product.SearchProductByNameOutputData;

public class SearchProductByNamePresenter implements SearchProductByNameOutputBoundary{

    final private ViewManagerModel viewManagerModel;
    final private SearchProductViewModel searchProductViewModel;

    public SearchProductByNamePresenter(ViewManagerModel viewManagerModel,
                                        SearchProductViewModel searchProductViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchProductViewModel = searchProductViewModel;
    }


    public void prepareSuccessfulView(SearchProductByNameOutputData searchProductByNameOutputData) {
        searchProductViewModel.setProducts(searchProductByNameOutputData.getProducts());
    }
}
