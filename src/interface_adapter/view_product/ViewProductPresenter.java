package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.ViewProductOutputBoundary;
import use_case.view_product.ViewProductOutputData;

public class ViewProductPresenter implements ViewProductOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    private final Non_loggedInViewModel nonLoggedInViewModel;

    private final ViewManagerModel viewManagerModel;

    public ViewProductPresenter(BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel sellerViewProductViewModel,
                                Non_loggedInViewModel nonLoggedInViewModel, ViewManagerModel viewManagerModel){
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.nonLoggedInViewModel = nonLoggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) {
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
        Non_loggedInState nonLoggedInState = nonLoggedInViewModel.getState();


        if(viewProductOutputData.getUser_type().equals("seller")) {
            sellerViewProductState.setProduct(viewProductOutputData.getProduct());
            sellerViewProductState.setLst_question(viewProductOutputData.getList_of_question());

            this.sellerViewProductViewModel.setState(sellerViewProductState);

            sellerViewProductViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
        else if (viewProductOutputData.getUser_type().equals("buyer")) {
            buyerViewProductState.setProduct(viewProductOutputData.getProduct());
            buyerViewProductState.setLst_question(viewProductOutputData.getList_of_question());

            this.buyerViewProductViewModel.setState(buyerViewProductState);

            buyerViewProductViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
        else{
            nonLoggedInState.setProduct(viewProductOutputData.getProduct());
            nonLoggedInState.setLst_question(viewProductOutputData.getList_of_question());

            this.nonLoggedInViewModel.setState(nonLoggedInState);

            nonLoggedInViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(nonLoggedInViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }

    }
}