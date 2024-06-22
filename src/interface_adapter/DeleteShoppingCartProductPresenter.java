package interface_adapter;

import use_case.DeleteShoppingCartProductOutputBoundary;
import use_case.DeleteShoppingCartProductOutputData;


public class DeleteShoppingCartProductPresenter implements DeleteShoppingCartProductOutputBoundary {
    private final ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteShoppingCartProductPresenter(ShoppingCartViewModel shoppingCartViewModel,
                                              ViewManagerModel viewManagerModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(DeleteShoppingCartProductOutputData response) {
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(response.getListProducts());
        shoppingCartState.setTotalPrice(response.getTotalPrice());

        this.shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
