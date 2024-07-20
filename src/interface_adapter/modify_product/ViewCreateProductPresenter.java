package interface_adapter.modify_product;

import interface_adapter.ViewManagerModel;
import use_case.modify_product.ViewCreateProductInputData;
import use_case.modify_product.ViewCreateProductOutputBoundary;
import use_case.modify_product.ViewCreateProductOutputData;

public class ViewCreateProductPresenter implements ViewCreateProductOutputBoundary  {
    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewCreateProductPresenter(ViewCreateProductViewModel viewCreateProductViewModel, ViewManagerModel viewManagerModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessfulView(ViewCreateProductOutputData createProductOutputData) {
        CreateProductState state = new CreateProductState();
        state.setUser(createProductOutputData.getUser());
       //TODO delete this after testing
        System.out.println(createProductOutputData.getUser().getName());
        this.viewCreateProductViewModel.setState(state);

        viewCreateProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewCreateProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
