package interface_adapter.modify_product.modify;

import interface_adapter.ViewManagerModel;
import use_case.modify_product.ViewModifyProductOutputBoundary;
import use_case.modify_product.ViewModifyProductOutputData;

/**
 * Presenter responsible for preparing the view for modifying a product.
 *
 * This presenter interacts with the view model to update the state with product details and notify
 * the view manager to display the appropriate view for modifying a product.
 */
public class ViewModifyProductPresenter implements ViewModifyProductOutputBoundary {
    private final ViewModifyProductViewModel viewModifyProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewModifyProductPresenter with the specified view model and view manager.
     *
     * @param viewModifyProductViewModel The view model for managing the view state related to modifying a product.
     * @param viewManagerModel The view manager model for handling view transitions.
     */
    public ViewModifyProductPresenter(ViewModifyProductViewModel viewModifyProductViewModel, ViewManagerModel viewManagerModel) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view with the product details for modification.
     *
     * Updates the view model state with the product and user details provided by the output data,
     * and then notifies the view manager to display the view for modifying the product.
     *
     * @param viewModifyProductOutputData The output data containing the product and user details.
     */
    @Override
    public void prepareSuccessfulView(ViewModifyProductOutputData viewModifyProductOutputData) {
        ViewModifyProductState state = viewModifyProductViewModel.getState();
        state.setProduct(viewModifyProductOutputData.getProduct());
        state.setUser(viewModifyProductOutputData.getUser());

        viewModifyProductViewModel.setState(state);
        viewModifyProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(viewModifyProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
