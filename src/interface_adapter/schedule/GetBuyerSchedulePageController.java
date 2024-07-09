package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.GetBuyerSchedulePageInputBoundary;
import use_case.schedule.GetBuyerSchedulePageInputData;

import java.io.IOException;
import java.sql.SQLException;

public class GetBuyerSchedulePageController {
    private GetBuyerSchedulePageInputBoundary inputBoundary;

    public GetBuyerSchedulePageController(GetBuyerSchedulePageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(User buyer, Product product) throws SQLException, IOException {
        GetBuyerSchedulePageInputData inputData = new GetBuyerSchedulePageInputData(buyer, product);
        inputBoundary.execute(inputData);
    }
}
