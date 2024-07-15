package interface_adapter.profile.manage_product;

import interface_adapter.ViewManagerModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.manage_product.ManageProductOutputData;

public class ManageProductPresenter implements ManageProductOutputBoundary {

    final private ManageProductViewModel manageProductViewModel;
    final private ViewManagerModel viewManagerModel;

    public ManageProductPresenter(ViewManagerModel viewManagerModel, ManageProductViewModel manageProductViewModel) {
        this.manageProductViewModel = manageProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ManageProductOutputData response) {
        ManageProductState manageProductState = manageProductViewModel.getState();
        manageProductState.setProduct(response.getProducts());
        manageProductState.setUser(response.getUser());

        this.manageProductViewModel.setState(manageProductState);

        viewManagerModel.firePropertyChanged();
        viewManagerModel.setActiveView(manageProductViewModel.getViewName());

    }
}
