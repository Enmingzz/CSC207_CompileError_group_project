package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.ViewProductOutputBoundary;
import use_case.view_product.ViewProductOutputData;

public class ViewProductPresenter implements ViewProductOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewProductPresenter(BuyerViewProductViewModel buyerViewProductViewModel,
                                ViewManagerModel viewManagerModel){
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) {
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();

        buyerViewProductState.setProduct(viewProductOutputData.getProduct());
        buyerViewProductState.setLst_question(viewProductOutputData.getList_of_question());

        this.buyerViewProductViewModel.setState(buyerViewProductState);

        buyerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}