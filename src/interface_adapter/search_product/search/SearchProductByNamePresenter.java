package interface_adapter.search_product.search;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.search_product.SearchProductByNameOutputBoundary;
import use_case.search_product.SearchProductByNameOutputData;

import java.util.ArrayList;

/**
 * The SearchProductByNamePresenter class implements the SearchProductByNameOutputBoundary interface
 * and handles the preparation of the successful view for searching products by name.
 */
public class SearchProductByNamePresenter implements SearchProductByNameOutputBoundary{

    final ViewManagerModel viewManagerModel;
    final SearchProductViewModel searchProductViewModel;

    /**
     * Constructs a SearchProductByNamePresenter.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the view model for the search product
     */
    public SearchProductByNamePresenter(ViewManagerModel viewManagerModel,
                                        SearchProductViewModel searchProductViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchProductViewModel = searchProductViewModel;
    }


    /**
     * Prepares the successful view with the given output data, refreshes the search page,
     * and displays the matching products with the search name.
     *
     * @param searchProductByNameOutputData the output data containing the user and list of matching products
     */
    public void prepareSuccessfulView(SearchProductByNameOutputData searchProductByNameOutputData) {
        SearchProductState searchProductState = searchProductViewModel.getState();
        User user = searchProductByNameOutputData.getUser();
        ArrayList<Product> products = searchProductByNameOutputData.getProducts();

        searchProductState.setUser(user);
        searchProductState.setProducts(products);
        this.searchProductViewModel.setState(searchProductState);

        searchProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
