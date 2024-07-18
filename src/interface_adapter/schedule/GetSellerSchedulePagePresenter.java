package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
import use_case.schedule.GetBuyerSchedulePageOutputData;
import use_case.schedule.GetSellerSchedulePageOutputBoundary;
import use_case.schedule.GetSellerSchedulePageOutputData;

/**
 * The GetSellerSchedulePagePresenter class implements the GetSellerSchedulePageOutputBoundary interface
 * and handles the preparation of the view for the get seller schedule page use case.
 */
public class GetSellerSchedulePagePresenter implements GetSellerSchedulePageOutputBoundary {
    private SellerSelectScheduleViewModel sellerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a GetSellerSchedulePagePresenter.
     *
     * @param sellerSelectScheduleViewModel the view model for the seller select schedule
     * @param viewManagerModel the view manager model
     */
    public GetSellerSchedulePagePresenter(SellerSelectScheduleViewModel sellerSelectScheduleViewModel,
                                         ViewManagerModel viewManagerModel) {
        this.sellerSelectScheduleViewModel = sellerSelectScheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the successful view by updating the state and switching the view to the seller schedule select page.
     *
     * @param getSellerSchedulePageOutputData the output data containing the seller and product information
     */
    public void prepareSuccessfulView(GetSellerSchedulePageOutputData getSellerSchedulePageOutputData) {
        SellerSelectScheduleState sellerSelectScheduleState = sellerSelectScheduleViewModel.getState();
        User seller = getSellerSchedulePageOutputData.getSeller();
        Product product = getSellerSchedulePageOutputData.getProduct();

        sellerSelectScheduleState.setSeller(seller);
        sellerSelectScheduleState.setProduct(product);

        this.sellerSelectScheduleViewModel.setState(sellerSelectScheduleState);

        sellerSelectScheduleViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(sellerSelectScheduleViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
