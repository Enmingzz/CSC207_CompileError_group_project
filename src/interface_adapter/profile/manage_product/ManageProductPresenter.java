package interface_adapter.profile.manage_product;

import interface_adapter.ViewManagerModel;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.manage_product.ManageProductOutputData;
/**
 * Presenter for managing products in the user's profile, responsible for preparing the view model and triggering view updates.
 */
public class ManageProductPresenter implements ManageProductOutputBoundary {

    final private ManageProductViewModel manageProductViewModel;
    final private ViewManagerModel viewManagerModel;
    /**
     * Constructs a {@link ManageProductPresenter} with the specified view manager model and manage product view model.
     *
     * @param viewManagerModel the view manager model to manage view changes
     * @param manageProductViewModel the view model for managing products
     */
    public ManageProductPresenter(ViewManagerModel viewManagerModel, ManageProductViewModel manageProductViewModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    /**
     * Prepares the successful view by updating the manage product state and triggering property changes.
     *
     * @param response the output data containing user and product information
     */
    @Override
    public void prepareSuccessfulView(ManageProductOutputData response) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        manageProductState.setProduct(response.getProducts());
        manageProductState.setUser(response.getUser());

        this.manageProductViewModel.setState(manageProductState);

        manageProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();


    }
}
