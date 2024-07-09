package interface_adapter.schedule;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.schedule.BuyerSelectScheduleOutputBoundary;
import use_case.schedule.BuyerSelectScheduleOutputData;

public class BuyerSelectSchedulePresenter implements BuyerSelectScheduleOutputBoundary {
    private BuyerSelectScheduleViewModel viewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    public BuyerSelectSchedulePresenter(BuyerSelectScheduleViewModel viewModel,
                                        ViewManagerModel viewManagerModel,
                                        ShoppingCartViewModel shoppingCartViewModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void presentScheduleSelection(BuyerSelectScheduleOutputData outputData) {
        //move to shopping_cart_View
        viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
