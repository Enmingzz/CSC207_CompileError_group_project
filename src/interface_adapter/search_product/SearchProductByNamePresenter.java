package interface_adapter.search_product;

import interface_adapter.ViewManagerModel;
import use_case.product_search.SearchProductByNameOutputBoundary;
import use_case.product_search.SearchProductByNameOutputData;
import view.product_search.SearchByNameView;

public class SearchProductByNamePresenter implements SearchProductByNameOutputBoundary{

    final private ViewManagerModel viewManagerModel;
    final private SearchByNameView searchByNameView;

    public SearchProductByNamePresenter(ViewManagerModel viewManagerModel, SearchByNameView searchByNameView) {
        this.viewManagerModel = viewManagerModel;
        this.searchByNameView = searchByNameView;
    }


    public void prepareSuccessfulView(SearchProductByNameOutputData searchProductByNameOutputData) {
        //TODO implements this
    }
}
