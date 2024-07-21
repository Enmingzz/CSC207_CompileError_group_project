package interface_adapter.main_page;

import interface_adapter.ViewManagerModel;
import use_case.main_page.ShowMainPageOutputData;
import use_case.main_page.ShowMainPageOutputBoundary;
import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;

/**
 * Presenter for the main page, responsible for preparing the view model and triggering view updates.
 */
public class MainPagePresenter implements ShowMainPageOutputBoundary {
    private final MainPageViewModel mainPageViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a {@link MainPagePresenter} with the specified view model and view manager model.
     *
     * @param mainPageViewModel the view model for the main page
     * @param viewManagerModel  the view manager model to manage view changes
     */
    public MainPagePresenter(MainPageViewModel mainPageViewModel,
                             ViewManagerModel viewManagerModel) {
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view by updating the main page state and triggering property changes.
     *
     * @param response the output data containing user and product information
     */
    @Override
    public void prepareSuccessView(ShowMainPageOutputData response) {
        MainPageState mainPageState = mainPageViewModel.getState();
        User user = response.getUser();
        ArrayList<Product> allProducts = response.getAllProducts();

        mainPageState.setUser(user);
        mainPageState.setAllProducts(allProducts);

        mainPageViewModel.setState(mainPageState);

        mainPageViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(mainPageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
