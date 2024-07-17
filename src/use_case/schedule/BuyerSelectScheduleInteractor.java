package use_case.schedule;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.sql.SQLException;
import java.io.IOException;

/**
 * The BuyerSelectScheduleInteractor class implements the BuyerSelectScheduleInputBoundary interface
 * and provides the implementation for selecting a schedule for a buyer.
 */
public class BuyerSelectScheduleInteractor implements BuyerSelectScheduleInputBoundary {
    private final BuyerSelectScheduleOutputBoundary outputBoundary;
    private final ProductReadByIdDataAccessInterface productReadById;
    private final ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerSchedule;
    private final ProductUpdateStateDataAccessInterface productUpdateState;


    /**
     * Constructs a BuyerSelectScheduleInteractor with the specified dependencies.
     *
     * @param outputBoundary the output boundary to handle the output data
     * @param productReadById the data access interface to read product by ID
     * @param productUpdateBuyerSchedule the data access interface to update the buyer's schedule
     * @param productUpdateState the data access interface to update the product state
     */
    public BuyerSelectScheduleInteractor(BuyerSelectScheduleOutputBoundary outputBoundary,
                                         ProductReadByIdDataAccessInterface productReadById,
                                         ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerSchedule,
                                         ProductUpdateStateDataAccessInterface productUpdateState) {
        this.outputBoundary = outputBoundary;
        this.productReadById = productReadById;
        this.productUpdateBuyerSchedule = productUpdateBuyerSchedule;
        this.productUpdateState = productUpdateState;
    }

    /**
     * Executes the process of selecting a schedule for a buyer.
     *
     * @param inputData the input data containing buyer, product, and selected schedule time
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void execute(BuyerSelectScheduleInputData inputData) throws SQLException, IOException {
        if (inputData.getSelectedTime() == null) {
            outputBoundary.prepareFailedView("No time selected. Please select a time.");
        }
        else {
            Product product = productReadById.getProductById(inputData.getProduct().getProductID());
            productUpdateBuyerSchedule.updateBuyerScheduleByProductID(product, inputData.getSelectedTime());

            productUpdateState.updateProductState(product, 3);
            Product updated_product = productReadById.getProductById(product.getProductID());

            BuyerSelectScheduleOutputData outputData = new BuyerSelectScheduleOutputData(inputData.getBuyer(),
                    updated_product);
            outputBoundary.prepareSuccessfulView(outputData);
        }

    }
}
