package interface_adapter;

import use_case.ViewProductInputData;
import use_case.ViewProductOutputBoundary;
import use_case.ViewProductOutputData;

public class ViewProductPresenter implements ViewProductOutputBoundary {
    private final ViewProductViewModel viewProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewProductPresenter(ViewProductViewModel viewProductViewModel,
                                ViewManagerModel viewManagerModel){
        this.viewProductViewModel = viewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) {
        ViewProductState viewProductState = viewProductViewModel.getState();

        viewProductState.setProduct(viewProductState.getProduct());
        viewProductState.setLst_question(viewProductOutputData.getList_of_question());

        this.viewProductViewModel.setState(viewProductState);

        viewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}