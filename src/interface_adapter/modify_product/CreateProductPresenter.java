package interface_adapter.modify_product;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import use_case.modify_product.CreateProductOutputBoundary;
import use_case.modify_product.CreateProductOutputData;

import java.util.ArrayList;
import java.util.Objects;

public class CreateProductPresenter implements CreateProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;
    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateProductPresenter(CreateProductOutputData createProductOutputData, ManageProductViewModel manageProductViewModel, CreateProductState createProductState, ViewCreateProductViewModel viewCreateProductViewModel, ViewManagerModel viewManagerModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewCreateProductViewModel = viewCreateProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) {
        //If the creation is successful, will we make sure to jump back to the view of the manage products page.
        //Note that when returning back, we need to ensure that the new product we just created is also in the user's manage products page.

        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> newArrayList = manageProductState.getProduct();
        newArrayList.add(createProductOutputData.getProduct());
        manageProductState.setProduct(newArrayList);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("Product View");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailedView(String error){
        CreateProductState createProductState = viewCreateProductViewModel.getState();
        if(Objects.equals(error, "You must upload a valid image of the product.")) {
            createProductState.setImageError(error);
        }
        else if(Objects.equals(error, "You must indicate a valid price of the product.")) {
            createProductState.setPirceError(error);
        }
        else if(Objects.equals(error, "You must provide a valid eTransfer email for the product.")) {
            createProductState.seteTransferEmailError(error);
        }
        else if(Objects.equals(error, "You must provide a valid address for the pickup location.")) {
            createProductState.setAddressError(error);
        }
        else if(Objects.equals(error, "You must select at least one tag for the product.")) {
            createProductState.setListTagsError(error);
        }
        viewCreateProductViewModel.setState(createProductState);
        viewCreateProductViewModel.firePropertyChanged();
    }

}
