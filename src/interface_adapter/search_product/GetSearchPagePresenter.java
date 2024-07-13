package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.search_product.GetSearchViewOutputBoundary;
import use_case.search_product.GetSearchViewOutputData;


import java.util.ArrayList;

public class GetSearchPagePresenter implements GetSearchViewOutputBoundary {
    private SearchProductViewModel searchProductViewModel;
    private ViewManagerModel viewManagerModel;

    public GetSearchPagePresenter(SearchProductViewModel searchProductViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.searchProductViewModel = searchProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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
