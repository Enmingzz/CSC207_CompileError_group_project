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

public class ModifyProductPresenter implements ChangeProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public ModifyProductPresenter(ManageProductViewModel manageProductViewModel, ViewManagerModel viewManagerModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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

        String message = changeProductOutputData.getMessage();
        manageProductState.setModifyProductMessage(message);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(manageProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
