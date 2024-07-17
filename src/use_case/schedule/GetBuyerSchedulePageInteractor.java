package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetBuyerSchedulePageInteractor class implements the GetBuyerSchedulePageInputBoundary interface
 * and provides the implementation for retrieving the schedule page for a buyer.
 */
public class GetBuyerSchedulePageInteractor implements GetBuyerSchedulePageInputBoundary{
    private final GetBuyerSchedulePageOutputBoundary getBuyerSchedulePageOutputBoundary;

    /**
     * Constructs a GetBuyerSchedulePageInteractor.
     *
     * @param getBuyerSchedulePageOutputBoundary the output boundary to handle the output data
     */
    public GetBuyerSchedulePageInteractor(GetBuyerSchedulePageOutputBoundary getBuyerSchedulePageOutputBoundary) {
        this.getBuyerSchedulePageOutputBoundary = getBuyerSchedulePageOutputBoundary;
    }

    /**
     * Executes the process of retrieving the schedule page for a buyer.
     *
     * @param getBuyerSchedulePageInputData the input data containing buyer and product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(GetBuyerSchedulePageInputData getBuyerSchedulePageInputData) throws SQLException, IOException {
        User buyer = getBuyerSchedulePageInputData.getBuyer();
        Product product = getBuyerSchedulePageInputData.getProduct();

        GetBuyerSchedulePageOutputData getBuyerSchedulePageOutputData = new GetBuyerSchedulePageOutputData(buyer, product);
        getBuyerSchedulePageOutputBoundary.prepareSuccessfulView(getBuyerSchedulePageOutputData);

    }
}
