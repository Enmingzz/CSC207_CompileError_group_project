package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.GetBuyerSchedulePageInputBoundary;
import use_case.schedule.GetBuyerSchedulePageInputData;

import java.io.IOException;
import java.sql.SQLException;

public class GetBuyerSchedulePageController {
    private GetBuyerSchedulePageInputBoundary inputBoundary;
    private final BuyerSelectScheduleState state;

    public void execute(User user, Product product) throws SQLException, IOException {
        state.setBuyer(user);
        state.setProduct(product);
        GetBuyerSchedulePageInputData inputData = new GetBuyerSchedulePageInputData();
        inputBoundary.execute(inputData);

}
