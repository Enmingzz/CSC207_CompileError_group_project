package interface_adapter.schedule;


import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputData;

import java.util.ArrayList;

public class SellerSelectSchedulePresenter implements SellerSelectScheduleOutputBoundary {
    private SellerSelectScheduleViewModel viewModel;
    private ViewProfileViewModel profileViewModel;
    private ViewManagerModel viewManagerModel;


    public SellerSelectSchedulePresenter(SellerSelectScheduleViewModel viewModel,
                                         ViewProfileViewModel profileViewModel,
                                         ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(SellerSelectScheduleOutputData outputData) {
        //move to profile view
        ViewProfileState profileState = profileViewModel.getState();
        ArrayList<Product> products = profileState.getProducts();
        Product updated_product = outputData.getProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(updated_product.getProductID())) {
                products.set(i, updated_product);
            }
        }
        profileState.setProducts(products);

        //change state error in buyerSchedule
        SellerSelectScheduleState sellerSelectScheduleState = viewModel.getState();
        sellerSelectScheduleState.setError(null);

        this.viewModel.setState(sellerSelectScheduleState);
        this.profileViewModel.setState(profileState);
        viewModel.firePropertyChanged();
        profileViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailedView(String error) {
        SellerSelectScheduleState sellerSelectScheduleState = viewModel.getState();
        sellerSelectScheduleState.setError(error);
        viewModel.setState(sellerSelectScheduleState);
        viewModel.firePropertyChanged();
    }
}
