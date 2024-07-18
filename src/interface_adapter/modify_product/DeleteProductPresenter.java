package interface_adapter.modify_product;

import entity.product.Product;
import interface_adapter.ViewManagerModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.modify_product.DeleteProductOutputBoundary;
import use_case.modify_product.DeleteProductOutputData;

import java.util.ArrayList;

public class DeleteProductPresenter implements DeleteProductOutputBoundary{
    private final ManageProductViewModel manageProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public DeleteProductPresenter(ManageProductViewModel manageProductViewModel, ViewManagerModel viewManagerModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(DeleteProductOutputData deleteProductOutputData){
        ManageProductState manageProductState = manageProductViewModel.getState();
        ArrayList<Product> newArrayList = manageProductState.getProduct();
        newArrayList.remove(deleteProductOutputData.getProduct());
        manageProductState.setProduct(newArrayList);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
