package use_case.schedule;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;

import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;


public class SellerSelectScheduleInteractor implements SellerSelectScheduleInputBoundary {
    private SellerSelectScheduleOutputBoundary outputBoundary;
    private ProductReadByIdDataAccessInterface productReadById;
    private ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerSchedule;
    private ProductUpdateStateDataAccessInterface productUpdateState;

    public SellerSelectScheduleInteractor(SellerSelectScheduleOutputBoundary outputBoundary,
                                          ProductReadByIdDataAccessInterface productReadById,
                                          ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerSchedule,
                                          ProductUpdateStateDataAccessInterface productUpdateState) {
        this.outputBoundary = outputBoundary;
        this.productReadById = productReadById;
        this.productUpdateSellerSchedule = productUpdateSellerSchedule;
        this.productUpdateState = productUpdateState;
    }

    @Override
    public void execute(SellerSelectScheduleInputData inputData) throws SQLException, IOException {
        if (inputData.getAvailableTimes().isEmpty()) {
            outputBoundary.prepareFailedView("No available times added. Please add at least one time.");
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

