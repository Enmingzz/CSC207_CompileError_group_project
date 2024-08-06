package interface_adapter.modify_product.create;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.modify_product.CreateProductOutputBoundary;
import use_case.modify_product.CreateProductOutputData;

import java.util.ArrayList;

/**
 * Presenter responsible for handling the output from the use case of creating a product.
 *
 * This presenter updates the view models based on the result of the product creation use case.
 * It updates the manage products view with the newly created product if the creation is successful,
 * and it sets an error message in the create product view if the creation fails.
 */
public class CreateProductPresenter implements CreateProductOutputBoundary {

    private final ManageProductViewModel manageProductViewModel;
    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a new CreateProductPresenter instance.
     *
     * @param manageProductViewModel The view model responsible for managing the product list.
     * @param viewCreateProductViewModel The view model responsible for the create product view.
     * @param viewManagerModel The view manager model that handles the switching between views.
     */
    public CreateProductPresenter(ManageProductViewModel manageProductViewModel,
                                  ViewCreateProductViewModel viewCreateProductViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewCreateProductViewModel = viewCreateProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful product creation.
     *
     * Updates the manage products view model with the newly created product and switches the view to
     * the manage products page.
     *
     * @param createProductOutputData The output data containing information about the newly created product.
     */
    @Override
    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> productList = manageProductState.getProduct();

        productList.add(createProductOutputData.getProduct());
        manageProductState.setProduct(productList);

        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed product creation.
     *
     * Sets an error message in the create product view model to be displayed to the user.
     *
     * @param error The error message indicating why the product creation failed.
     */
    @Override
    public void prepareFailedView(String error) {
        CreateProductState createProductState = viewCreateProductViewModel.getState();
        createProductState.setCreateProductError(error);

        viewCreateProductViewModel.setState(createProductState);
        viewCreateProductViewModel.firePropertyChanged();

        createProductState.setCreateProductError(null);
    }
}
