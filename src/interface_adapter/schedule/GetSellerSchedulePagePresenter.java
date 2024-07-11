package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
import use_case.schedule.GetBuyerSchedulePageOutputData;
import use_case.schedule.GetSellerSchedulePageOutputBoundary;
import use_case.schedule.GetSellerSchedulePageOutputData;

public class GetSellerSchedulePagePresenter implements GetSellerSchedulePageOutputBoundary {
    private final SellerSelectScheduleViewModel sellerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;

    public GetSellerSchedulePagePresenter(SellerSelectScheduleViewModel sellerSelectScheduleViewModel,
                                         ViewManagerModel viewManagerModel) {
        this.sellerSelectScheduleViewModel = sellerSelectScheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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
