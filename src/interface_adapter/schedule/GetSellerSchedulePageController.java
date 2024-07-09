package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.GetSellerSchedulePageInputBoundary;
import use_case.schedule.GetSellerSchedulePageInputData;

import java.io.IOException;
import java.sql.SQLException;

public class GetSellerSchedulePageController {
    private GetSellerSchedulePageInputBoundary inputBoundary;

    public GetSellerSchedulePageController(GetSellerSchedulePageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(User seller, Product product) throws SQLException, IOException {
        GetSellerSchedulePageInputData inputData = new GetSellerSchedulePageInputData(seller, product);
        inputBoundary.execute(inputData);
    }
}
