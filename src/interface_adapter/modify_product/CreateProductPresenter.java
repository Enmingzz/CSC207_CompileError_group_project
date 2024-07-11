package interface_adapter.modify_product;

import entity.product.Product;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import use_case.modify_product.CreateProductOutputBoundary;
import use_case.modify_product.CreateProductOutputData;

import java.util.ArrayList;

public class CreateProductPresenter implements CreateProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;
    private final ViewCreateProductViewModel viewCreateProductViewModel;

    public CreateProductPresenter(CreateProductOutputData createProductOutputData, ManageProductViewModel manageProductViewModel, CreateProductState createProductState, ViewCreateProductViewModel viewCreateProductViewModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewCreateProductViewModel = viewCreateProductViewModel;
    }

    @Override
    public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> newArrayList = manageProductState.getProduct();
        newArrayList.add(createProductOutputData.getProduct());
        manageProductState.setProduct(newArrayList);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();
        //Example: manageProductState._____  = createProductOutputData.getProduct().getProductID();
        //If the creation is successful, will we make sure to jump back to the new state.
    }

    @Override
    public void prepareFailedView(String error){
        CreateProductState createProductState = viewCreateProductViewModel.getState();
        createProductState.setError(error);
        viewCreateProductViewModel.setState(createProductState);

        //TODO finish updating this part with all the different possible errors?
        //where all the create product output data are...???

    }

}
