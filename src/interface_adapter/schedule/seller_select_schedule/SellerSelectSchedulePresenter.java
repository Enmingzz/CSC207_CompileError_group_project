package interface_adapter.schedule.seller_select_schedule;


import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputData;

import java.util.ArrayList;

/**
 * The SellerSelectSchedulePresenter class implements the SellerSelectScheduleOutputBoundary interface
 * and handles the preparation of the view for the seller select schedule use case.
 */
public class SellerSelectSchedulePresenter implements SellerSelectScheduleOutputBoundary {
    private SellerSelectScheduleViewModel viewModel;
    private ManageProductViewModel manageProductViewModel;
    private ViewManagerModel viewManagerModel;


    /**
     * Constructs a SellerSelectSchedulePresenter.
     *
     * @param viewModel the view model for the seller select schedule
     * @param manageProductViewModel the view model for managing products
     * @param viewManagerModel the view manager model
     */
    public SellerSelectSchedulePresenter(SellerSelectScheduleViewModel viewModel,
                                         ManageProductViewModel manageProductViewModel,
                                         ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view by updating the state and switching the view to the manage product view.
     *
     * @param outputData the output data containing the updated product
     */
    @Override
    public void prepareSuccessfulView(SellerSelectScheduleOutputData outputData) {
        //move to manage product view
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> products = manageProductState.getProduct();
        Product updated_product = outputData.getProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(updated_product.getProductID())) {
                products.set(i, updated_product);
            }
        }
        manageProductState.setProduct(products);

        //change state error in buyerSchedule
        SellerSelectScheduleState sellerSelectScheduleState = viewModel.getState();
        sellerSelectScheduleState.setError(null);

        this.viewModel.setState(sellerSelectScheduleState);
        this.manageProductViewModel.setState(manageProductState);
        viewModel.firePropertyChanged();
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failed view with the given error message.
     *
     * @param error the error message to display
     */
    public void prepareFailedView(String error) {
        SellerSelectScheduleState sellerSelectScheduleState = viewModel.getState();
        sellerSelectScheduleState.setError(error);
        viewModel.setState(sellerSelectScheduleState);
        viewModel.firePropertyChanged();
    }
}
