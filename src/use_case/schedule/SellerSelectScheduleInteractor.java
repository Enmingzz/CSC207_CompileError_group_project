package use_case.schedule;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;

import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The SellerSelectScheduleInteractor class implements the SellerSelectScheduleInputBoundary interface
 * and provides the implementation for selecting a schedule for a seller.
 */
public class SellerSelectScheduleInteractor implements SellerSelectScheduleInputBoundary {
    private final SellerSelectScheduleOutputBoundary outputBoundary;
    private final ProductReadByIdDataAccessInterface productReadById;
    private final ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerSchedule;
    private final ProductUpdateStateDataAccessInterface productUpdateState;

    /**
     * Constructs a SellerSelectScheduleInteractor with the specified dependencies.
     *
     * @param outputBoundary the output boundary to handle the output data
     * @param productReadById the data access interface to read product by ID
     * @param productUpdateSellerSchedule the data access interface to update the seller's schedule
     * @param productUpdateState the data access interface to update the product state
     */
    public SellerSelectScheduleInteractor(SellerSelectScheduleOutputBoundary outputBoundary,
                                          ProductReadByIdDataAccessInterface productReadById,
                                          ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerSchedule,
                                          ProductUpdateStateDataAccessInterface productUpdateState) {
        this.outputBoundary = outputBoundary;
        this.productReadById = productReadById;
        this.productUpdateSellerSchedule = productUpdateSellerSchedule;
        this.productUpdateState = productUpdateState;
    }

    /**
     * Executes the process of selecting a schedule for a seller.
     *
     * @param inputData the input data containing seller, product, and available schedule times
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void execute(SellerSelectScheduleInputData inputData) throws SQLException, IOException {
        if (inputData.getAvailableTimes().isEmpty()) {
            outputBoundary.prepareFailedView("No available times have been added. Please add at least one available time.");
        } else {
            Product product = productReadById.getProductById(inputData.getProduct().getProductID());
            ArrayList<LocalDateTime> availableTimes = inputData.getAvailableTimes();
            productUpdateSellerSchedule.updateSellerSchedule(product, availableTimes);

            productUpdateState.updateProductState(product, 2);

            Product updated_product = productReadById.getProductById(product.getProductID());
            SellerSelectScheduleOutputData outputData = new SellerSelectScheduleOutputData(inputData.getSeller(),
                    updated_product);
            outputBoundary.prepareSuccessfulView(outputData);
        }
    }
}

