package interface_adapter.modify_product;

import interface_adapter.ViewManagerModel;
import use_case.modify_product.ViewModifyProductOutputBoundary;
import use_case.modify_product.ViewModifyProductOutputData;

public class ViewModifyProductPresenter implements ViewModifyProductOutputBoundary {
    private final ViewModifyProductViewModel viewModifyProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewModifyProductPresenter(ViewModifyProductViewModel viewModifyProductViewModel, ViewManagerModel viewManagerModel) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ViewModifyProductOutputData viewModifyProductOutputData) {
        ViewModifyProductState state = viewModifyProductViewModel.getState();
        state.setProduct(viewModifyProductOutputData.getProduct());
        state.setUser(viewModifyProductOutputData.getUser());

        viewModifyProductViewModel.setState(state);
        viewModifyProductViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(viewModifyProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


}
