package interface_adapter.schedule.buyer_select_schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
import use_case.schedule.GetBuyerSchedulePageOutputData;

/**
 * The GetBuyerSchedulePagePresenter class implements the GetBuyerSchedulePageOutputBoundary interface
 * and handles the preparation of the view for the get buyer schedule page use case.
 */
public class GetBuyerSchedulePagePresenter implements GetBuyerSchedulePageOutputBoundary {
    private BuyerSelectScheduleViewModel buyerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a GetBuyerSchedulePagePresenter.
     *
     * @param buyerSelectScheduleViewModel the view model for the buyer select schedule
     * @param viewManagerModel the view manager model
     */
    public GetBuyerSchedulePagePresenter(BuyerSelectScheduleViewModel buyerSelectScheduleViewModel,
                             ViewManagerModel viewManagerModel) {
        this.buyerSelectScheduleViewModel = buyerSelectScheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view by updating the state and switching the view to the buyer schedule select page.
     *
     * @param getBuyerSchedulePageOutputData the output data containing the buyer and product information
     */

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
