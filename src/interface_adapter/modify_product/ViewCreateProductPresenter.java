package interface_adapter.modify_product;

import interface_adapter.ViewManagerModel;
import use_case.modify_product.ViewCreateProductInputData;
import use_case.modify_product.ViewCreateProductOutputBoundary;
import use_case.modify_product.ViewCreateProductOutputData;

/**
 * Presenter for handling the output of viewing the create product page.
 *
 * This presenter interacts with the view model and the view manager to update the view
 * with the necessary data when the user is successfully retrieved or when an error occurs.
 */
public class ViewCreateProductPresenter implements ViewCreateProductOutputBoundary {

    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewCreateProductPresenter with the specified view model and view manager.
     *
     * @param viewCreateProductViewModel The view model for the create product view.
     * @param viewManagerModel The view manager model for managing the view state.
     */
    public ViewCreateProductPresenter(ViewCreateProductViewModel viewCreateProductViewModel, ViewManagerModel viewManagerModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view to display the successful creation of a product.
     *
     * This method updates the view model with the data provided by the output data, including
     * the user information, and sets the active view in the view manager.
     *
     * @param createProductOutputData The output data containing the user information and other details.
     */
    @Override
    public void prepareSuccessfulView(ViewCreateProductOutputData createProductOutputData) {
        CreateProductState state = new CreateProductState();
        state.setUser(createProductOutputData.getUser());

        // TODO: Remove this debugging output after testing
        System.out.println(createProductOutputData.getUser().getName());

        this.viewCreateProductViewModel.setState(state);
        viewCreateProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(viewCreateProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
