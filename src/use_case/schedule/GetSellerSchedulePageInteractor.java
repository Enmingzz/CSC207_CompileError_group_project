package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

public class GetSellerSchedulePageInteractor implements GetSellerSchedulePageInputBoundary{
    private final GetSellerSchedulePageOutputBoundary getSellerSchedulePageOutputBoundary;

    public GetSellerSchedulePageInteractor(GetSellerSchedulePageOutputBoundary getSellerSchedulePageOutputBoundary) {
        this.getSellerSchedulePageOutputBoundary = getSellerSchedulePageOutputBoundary;
    }

    public void execute(GetSellerSchedulePageInputData getSellerSchedulePageInputData) throws SQLException, IOException {
        User seller = getSellerSchedulePageInputData.getSeller();
        Product product = getSellerSchedulePageInputData.getProduct();

        GetSellerSchedulePageOutputData getSellerSchedulePageOutputData = new GetSellerSchedulePageOutputData(seller, product);
        getSellerSchedulePageOutputBoundary.prepareSuccessfulView(getSellerSchedulePageOutputData);

    }

}
