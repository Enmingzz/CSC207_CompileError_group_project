package interface_adapter.search_product.view_search_page;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_product.search.SearchProductState;
import interface_adapter.search_product.search.SearchProductViewModel;
import use_case.search_product.GetSearchViewOutputBoundary;
import use_case.search_product.GetSearchViewOutputData;


import java.util.ArrayList;

/**
 * The GetSearchPagePresenter class implements the GetSearchViewOutputBoundary interface
 * and handles the preparation of the successful view for the search page.
 */
public class GetSearchPagePresenter implements GetSearchViewOutputBoundary {
    private SearchProductViewModel searchProductViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a GetSearchPagePresenter.
     *
     * @param searchProductViewModel the view model for the search product
     * @param viewManagerModel the view manager model
     */
    public GetSearchPagePresenter(SearchProductViewModel searchProductViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.searchProductViewModel = searchProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view with the given output data and navigates to the search page.
     *
     * @param getSearchViewOutputData the output data containing the user and list of all on sale products
     */
    public void prepareSuccessView(GetSearchViewOutputData getSearchViewOutputData) {
        SearchProductState searchProductState = searchProductViewModel.getState();
        User user = getSearchViewOutputData.getUser();
        ArrayList<Product> products = getSearchViewOutputData.getAllProducts();

        searchProductState.setUser(user);
        searchProductState.setProducts(products);
        this.searchProductViewModel.setState(searchProductState);

        searchProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
