package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.GetSellerSchedulePageInputBoundary;
import use_case.schedule.GetSellerSchedulePageInputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetSellerSchedulePageController class handles the request to retrieve the schedule page for a seller.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class GetSellerSchedulePageController {
    private GetSellerSchedulePageInputBoundary inputBoundary;

    /**
     * Constructs a GetSellerSchedulePageController.
     *
     * @param inputBoundary the input boundary to handle the get seller schedule page use case
     */
    public GetSellerSchedulePageController(GetSellerSchedulePageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Executes the process of retrieving the schedule page for the given seller and product.
     *
     * @param seller the seller requesting the schedule page
     * @param product the product associated with the schedule
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User seller, Product product) throws SQLException, IOException {
        GetSellerSchedulePageInputData inputData = new GetSellerSchedulePageInputData(seller, product);
        inputBoundary.execute(inputData);
    }
}
