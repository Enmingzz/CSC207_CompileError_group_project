package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.search_product.SearchProductByNameOutputBoundary;
import use_case.search_product.SearchProductByNameOutputData;

import java.util.ArrayList;

public class SearchProductByNamePresenter implements SearchProductByNameOutputBoundary{

    final private ViewManagerModel viewManagerModel;
    final private SearchProductViewModel searchProductViewModel;

    public SearchProductByNamePresenter(ViewManagerModel viewManagerModel,
                                        SearchProductViewModel searchProductViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchProductViewModel = searchProductViewModel;
    }


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
