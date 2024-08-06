package interface_adapter.view_product.non_logged_in_view;

import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductState;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import interface_adapter.view_product.seller_view.SellerViewProductState;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
import use_case.view_product.ViewProductOutputBoundary;
import use_case.view_product.ViewProductOutputData;

/**
 * The ViewProductPresenter class implements the ViewProductOutputBoundary
 * and handles the presentation logic for viewing a product.
 */
public class ViewProductPresenter implements ViewProductOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    private final UnloggedInViewModel nonLoggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewProductPresenter with the specified view models and view manager model.
     *
     * @param buyerViewProductViewModel the view model for the buyer's product view.
     * @param sellerViewProductViewModel the view model for the seller's product view.
     * @param nonLoggedInViewModel the view model for the non-logged-in product view.
     * @param viewManagerModel the view manager model to manage active views.
     */
    public ViewProductPresenter(BuyerViewProductViewModel buyerViewProductViewModel,
                                SellerViewProductViewModel sellerViewProductViewModel,
                                UnloggedInViewModel nonLoggedInViewModel,
                                ViewManagerModel viewManagerModel) {
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.nonLoggedInViewModel = nonLoggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful product view request.
     *
     * @param viewProductOutputData the output data containing the product and user details.
     */
    @Override
    public void prepareViewSucceed(ViewProductOutputData viewProductOutputData) {

        System.out.println("view product presenter being called");

        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
        UnloggedInState nonLoggedInState = nonLoggedInViewModel.getState();

        switch (viewProductOutputData.getUser_type()) {
            case "seller":
                sellerViewProductState.setProduct(viewProductOutputData.getProduct());
                sellerViewProductState.setLst_question(viewProductOutputData.getList_of_question());
                sellerViewProductState.setUser(viewProductOutputData.getUser());
                sellerViewProductState.setIsChanged(true);

                sellerViewProductViewModel.setState(sellerViewProductState);
                sellerViewProductViewModel.firePropertyChanged();
                viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
                break;

            case "buyer":
                buyerViewProductState.setProduct(viewProductOutputData.getProduct());
                buyerViewProductState.setLst_question(viewProductOutputData.getList_of_question());
                buyerViewProductState.setUser(viewProductOutputData.getUser());
                buyerViewProductState.setIsChanged(true);

                buyerViewProductViewModel.setState(buyerViewProductState);
                buyerViewProductViewModel.firePropertyChanged();
                viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
                break;

            default:
                nonLoggedInState.setProduct(viewProductOutputData.getProduct());
                nonLoggedInState.setLst_question(viewProductOutputData.getList_of_question());
                nonLoggedInState.setUser(viewProductOutputData.getUser());
                nonLoggedInState.setIsChanged(true);

                nonLoggedInViewModel.setState(nonLoggedInState);
                nonLoggedInViewModel.firePropertyChanged();
                viewManagerModel.setActiveView(nonLoggedInViewModel.getViewName());
                break;
        }
        viewManagerModel.firePropertyChanged();
    }
}
