package interface_adapter.modify_product;

import use_case.modify_product.ViewModifyProductOutputBoundary;
import use_case.modify_product.ViewModifyProductOutputData;

public class ViewModifyProductPresenter implements ViewModifyProductOutputBoundary {
    private final ViewModifyProductViewModel viewModifyProductViewModel;

    public ViewModifyProductPresenter(ViewModifyProductViewModel viewModifyProductViewModel) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
    }

    @Override
    public void prepareSuccessfulView(ViewModifyProductOutputData viewModifyProductOutputData) {
        ViewModifyProductState state = viewModifyProductViewModel.getState();
        viewModifyProductViewModel.setState(state);
        viewModifyProductViewModel.firePropertyChanged();
    }


}
