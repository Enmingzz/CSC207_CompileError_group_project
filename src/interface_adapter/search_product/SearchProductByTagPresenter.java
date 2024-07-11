package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.search_product.SearchProductByTagOutputBoundary;
import use_case.search_product.SearchProductByTagOutputData;

import java.util.ArrayList;

public class SearchProductByTagPresenter implements SearchProductByTagOutputBoundary {
    private final SearchProductViewModel viewModel;
    private ViewManagerModel viewManagerModel;

    public SearchProductByTagPresenter(SearchProductViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

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
