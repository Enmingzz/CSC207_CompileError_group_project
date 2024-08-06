package interface_adapter.modify_product.delete;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.modify_product.DeleteProductOutputBoundary;
import use_case.modify_product.DeleteProductOutputData;

import java.util.ArrayList;

/**
 * Presenter for handling the output of a product deletion use case.
 *
 * This class updates the manage product view model to reflect the successful deletion of a product and ensures that
 * the view is updated accordingly.
 */
public class DeleteProductPresenter implements DeleteProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a new DeleteProductPresenter with the specified ManageProductViewModel and ViewManagerModel.
     *
     * @param manageProductViewModel The view model managing the product list to be updated.
     * @param viewManagerModel The view manager model used to switch views.
     */
    public DeleteProductPresenter(ManageProductViewModel manageProductViewModel, ViewManagerModel viewManagerModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful product deletion.
     *
     * This method updates the manage product view model by removing the deleted product from the list and sets the
     * view to the updated manage product view. It also ensures that the view manager is notified of the view change.
     *
     * @param deleteProductOutputData The output data containing information about the deleted product.
     */
    @Override
    public void prepareSuccessfulView(DeleteProductOutputData deleteProductOutputData) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> productList = manageProductState.getProduct();

        // Remove the deleted product from the product list
        productList.remove(deleteProductOutputData.getProduct());

        // Update the state and notify the view model of changes
        manageProductState.setProduct(productList);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        // Switch to the manage product view and notify the view manager of the view change
        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
