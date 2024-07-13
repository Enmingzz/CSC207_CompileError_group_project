package interface_adapter.modify_product;

import entity.product.Product;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import use_case.modify_product.ChangeProductOutputBoundary;
import use_case.modify_product.ChangeProductOutputData;

import java.util.ArrayList;
import java.util.Objects;

public class ModifyProductPresenter implements ChangeProductOutputBoundary {
    private final ManageProductViewModel manageProductViewModel;

    public ModifyProductPresenter(ManageProductViewModel manageProductViewModel) {
        this.manageProductViewModel = manageProductViewModel;
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
        String message = changeProductOutputData.getMessage();
        //TODO have not yet implemented the message...?
        manageProductState.setProduct(productList);
        manageProductViewModel.setState(manageProductState);
        manageProductViewModel.firePropertyChanged();
    }
}
