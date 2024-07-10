package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

public class GetBuyerSchedulePageInteractor implements GetBuyerSchedulePageInputBoundary{
    private final GetBuyerSchedulePageOutputBoundary getBuyerSchedulePageOutputBoundary;

    public GetBuyerSchedulePageInteractor(GetBuyerSchedulePageOutputBoundary getBuyerSchedulePageOutputBoundary) {
        this.getBuyerSchedulePageOutputBoundary = getBuyerSchedulePageOutputBoundary;
    }

    public void execute(GetBuyerSchedulePageInputData getBuyerSchedulePageInputData) throws SQLException, IOException {
        User buyer = getBuyerSchedulePageInputData.getBuyer();
        Product product = getBuyerSchedulePageInputData.getProduct();

        GetBuyerSchedulePageOutputData getBuyerSchedulePageOutputData = new GetBuyerSchedulePageOutputData(buyer, product);
        getBuyerSchedulePageOutputBoundary.prepareSuccessfulView(getBuyerSchedulePageOutputData);

    }
}
