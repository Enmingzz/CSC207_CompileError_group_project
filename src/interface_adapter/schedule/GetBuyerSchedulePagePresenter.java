package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
import use_case.schedule.GetBuyerSchedulePageOutputData;

public class GetBuyerSchedulePagePresenter implements GetBuyerSchedulePageOutputBoundary {
    private final BuyerSelectScheduleViewModel buyerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;

    public GetBuyerSchedulePagePresenter(BuyerSelectScheduleViewModel buyerSelectScheduleViewModel,
                             ViewManagerModel viewManagerModel) {
        this.buyerSelectScheduleViewModel = buyerSelectScheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessfulView(GetBuyerSchedulePageOutputData getBuyerSchedulePageOutputData) {
        BuyerSelectScheduleState buyerSelectScheduleState = buyerSelectScheduleViewModel.getState();
        User buyer = getBuyerSchedulePageOutputData.getBuyer();
        Product product = getBuyerSchedulePageOutputData.getProduct();

        buyerSelectScheduleState.setBuyer(buyer);
        buyerSelectScheduleState.setProduct(product);

        this.buyerSelectScheduleViewModel.setState(buyerSelectScheduleState);

        buyerSelectScheduleViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(buyerSelectScheduleViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
