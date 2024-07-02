package interface_adapter.profile.ManageProduct;

import interface_adapter.ViewManagerModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.manage_product.ManageProductOutputData;

public class ManageProductPresenter implements ManageProductOutputBoundary {

    final private ViewModifyProductViewModel modifyProductViewModel;
    final private ViewManagerModel viewManagerModel;

    public ManageProductPresenter(ViewManagerModel viewManagerModel, ViewModifyProductViewModel modifyProductViewModel) {
        this.modifyProductViewModel = modifyProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessfulView(ManageProductOutputData response) {
        // TODO need to implement this method
    }
}
