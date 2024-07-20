package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.ViewProductOutputBoundary;
import use_case.view_product.ViewProductOutputData;

public class ViewProductPresenter implements ViewProductOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    private final UnloggedInViewModel nonLoggedInViewModel;

    private final ViewManagerModel viewManagerModel;

    public ViewProductPresenter(BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel sellerViewProductViewModel,
                                UnloggedInViewModel nonLoggedInViewModel, ViewManagerModel viewManagerModel){
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.nonLoggedInViewModel = nonLoggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) {

        System.out.println("view product presenter being called");

        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
        UnloggedInState nonLoggedInState = nonLoggedInViewModel.getState();


        if(viewProductOutputData.getUser_type().equals("seller")) {
            sellerViewProductState.setProduct(viewProductOutputData.getProduct());
            sellerViewProductState.setLst_question(viewProductOutputData.getList_of_question());
            sellerViewProductState.setUser(viewProductOutputData.getUser());
            sellerViewProductState.setIsChanged(true);

            this.sellerViewProductViewModel.setState(sellerViewProductState);

            sellerViewProductViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
        else if (viewProductOutputData.getUser_type().equals("buyer")) {
            buyerViewProductState.setProduct(viewProductOutputData.getProduct());
            buyerViewProductState.setLst_question(viewProductOutputData.getList_of_question());
            buyerViewProductState.setUser(viewProductOutputData.getUser());
            buyerViewProductState.setIsChanged(true);

            this.buyerViewProductViewModel.setState(buyerViewProductState);

            buyerViewProductViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
        else{
            System.out.println("unlogged in is ");
            nonLoggedInState.setProduct(viewProductOutputData.getProduct());
            nonLoggedInState.setLst_question(viewProductOutputData.getList_of_question());
            nonLoggedInState.setUser(viewProductOutputData.getUser());
            nonLoggedInState.setIsChanged(true);

            this.nonLoggedInViewModel.setState(nonLoggedInState);

            nonLoggedInViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(nonLoggedInViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }

    }
}