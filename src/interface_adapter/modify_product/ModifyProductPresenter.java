package interface_adapter.modify_product;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.modify_product.ChangeProductOutputBoundary;
import use_case.modify_product.ChangeProductOutputData;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Presenter for handling the output of product modification operations.
 *
 * This class updates the view to reflect the changes made to a product, either by displaying the updated product
 * details or by showing an error message if the modification fails.
 */
public class ModifyProductPresenter implements ChangeProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;
    private final ViewModifyProductViewModel viewModifyProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ModifyProductPresenter with the specified view models and view manager model.
     *
     * @param manageProductViewModel The view model responsible for managing the product list.
     * @param viewManagerModel The view manager model used for switching views.
     * @param viewModifyProductViewModel The view model for the modify product view.
     */
    public ModifyProductPresenter(ManageProductViewModel manageProductViewModel, ViewManagerModel viewManagerModel,
                                  ViewModifyProductViewModel viewModifyProductViewModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view to display the successful result of a product modification.
     *
     * Updates the product list in the manage product view model with the modified product details and sets a success message.
     *
     * @param changeProductOutputData The output data containing the result of the modification and any messages.
     */
    @Override
    public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> productList = manageProductState.getProduct();
        Product updatedProduct = changeProductOutputData.getProduct();

        for (Product pro : productList) {
            if (Objects.equals(pro.getProductID(), updatedProduct.getProductID())) {
                int index = productList.indexOf(pro);
                productList.set(index, updatedProduct);
                break;
            }
        }

        manageProductState.setProduct(productList);

        // TODO: Remove this code later; it's only for testing
        // System.out.println(changeProductOutputData.getMessage());
        // System.out.println(changeProductOutputData.getProduct().getDescription());
        // System.out.println(changeProductOutputData.getProduct().getPrice());

        String message = changeProductOutputData.getMessage();
        manageProductState.setModifyProductMessage(message);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        // TODO: Clear message if needed
        // manageProductState.setModifyProductMessage(null);
        // manageProductViewModel.setState(manageProductState);
    }

    /**
     * Prepares the view to display the failure result of a product modification.
     *
     * Sets the error message in the modify product view model to inform the user about the modification failure.
     *
     * @param changeProductOutputData The output data containing the failure message.
     */
    @Override
    public void prepareFailView(ChangeProductOutputData changeProductOutputData) {
        ViewModifyProductState state = viewModifyProductViewModel.getState();
        state.setMessage(changeProductOutputData.getMessage());

        viewModifyProductViewModel.setState(state);
        manageProductViewModel.firePropertyChanged();
    }
}
