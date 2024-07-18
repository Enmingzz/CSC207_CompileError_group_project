package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.GetBuyerSchedulePageInputBoundary;
import use_case.schedule.GetBuyerSchedulePageInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetBuyerSchedulePageController class handles the request to retrieve the schedule page for a buyer.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class GetBuyerSchedulePageController {
    private final GetBuyerSchedulePageInputBoundary inputBoundary;

    /**
     * Constructs a GetBuyerSchedulePageController with the specified input boundary.
     *
     * @param inputBoundary the input boundary to handle the get buyer schedule page use case
     */
    public GetBuyerSchedulePageController(GetBuyerSchedulePageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Executes the process of retrieving the schedule page for the given buyer and product.
     *
     * @param buyer the buyer requesting the schedule page
     * @param product the product associated with the schedule
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User buyer, Product product) throws SQLException, IOException {
        GetBuyerSchedulePageInputData inputData = new GetBuyerSchedulePageInputData(buyer, product);
        inputBoundary.execute(inputData);
    }
}
