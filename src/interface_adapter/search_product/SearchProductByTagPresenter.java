package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.search_product.SearchProductByTagOutputBoundary;
import use_case.search_product.SearchProductByTagOutputData;

import java.util.ArrayList;


/**
 * The SearchProductByTagPresenter class implements the SearchProductByTagOutputBoundary interface
 * and handles the preparation of the successful view for searching products by tag.
 */
public class SearchProductByTagPresenter implements SearchProductByTagOutputBoundary {
    private final SearchProductViewModel viewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a SearchProductByTagPresenter.
     *
     * @param viewModel the view model for the search product
     * @param viewManagerModel the view manager model
     */
    public SearchProductByTagPresenter(SearchProductViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view with the given output data.
     *
     * @param searchProductByTagOutputData the output data containing the user and list of matching products
     */
    @Override
    public void prepareSuccessfulView(SearchProductByTagOutputData searchProductByTagOutputData) {
        SearchProductState searchProductState = viewModel.getState();
        User user = searchProductByTagOutputData.getUser();
        ArrayList<Product> products = searchProductByTagOutputData.getProducts();

        searchProductState.setUser(user);
        searchProductState.setProducts(products);
        this.viewModel.setState(searchProductState);

        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
