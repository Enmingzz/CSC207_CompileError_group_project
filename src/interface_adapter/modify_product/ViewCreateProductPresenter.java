package interface_adapter.modify_product;

import use_case.modify_product.ViewCreateProductInputData;
import use_case.modify_product.ViewCreateProductOutputBoundary;
import use_case.modify_product.ViewCreateProductOutputData;

public class ViewCreateProductPresenter {
    private final ViewCreateProductViewModel viewCreateProductViewModel;

    public ViewCreateProductPresenter(ViewCreateProductOutputData viewCreateProductOutputData, ViewCreateProductViewModel viewCreateProductViewModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
    }

    @overide
    public void prepareSuccessfulView(ViewCreateProductOutputData createProductOutputData) {
        viewCreateProductViewModel.setActiveView(rateProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
