package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The GetSellerSchedulePageInteractor class implements the GetSellerSchedulePageInputBoundary interface
 * and provides the implementation for gathering all necessary data to display the schedule page for a seller.
 */
public class GetSellerSchedulePageInteractor implements GetSellerSchedulePageInputBoundary{
    private final GetSellerSchedulePageOutputBoundary getSellerSchedulePageOutputBoundary;

    /**
     * Constructs a GetSellerSchedulePageInteractor with the specified output boundary.
     *
     * @param getSellerSchedulePageOutputBoundary the output boundary to handle the output data
     */
    public GetSellerSchedulePageInteractor(GetSellerSchedulePageOutputBoundary getSellerSchedulePageOutputBoundary) {
        this.getSellerSchedulePageOutputBoundary = getSellerSchedulePageOutputBoundary;
    }

    /**
     * Executes the process of gathering all necessary data to display the schedule page for a seller.
     *
     * @param getSellerSchedulePageInputData the input data containing seller and product information
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(GetSellerSchedulePageInputData getSellerSchedulePageInputData) throws SQLException, IOException {
        User seller = getSellerSchedulePageInputData.getSeller();
        Product product = getSellerSchedulePageInputData.getProduct();

        GetSellerSchedulePageOutputData getSellerSchedulePageOutputData = new GetSellerSchedulePageOutputData(seller, product);
        getSellerSchedulePageOutputBoundary.prepareSuccessfulView(getSellerSchedulePageOutputData);

    }

}
