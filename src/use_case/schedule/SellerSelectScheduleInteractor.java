package use_case.schedule;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;

import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void execute(SellerSelectScheduleInputData inputData) {
        boolean success = false;
        try {
            Product product = productReadById.getProductById(inputData.getProductId());
            ArrayList<LocalDateTime> availableTimes = inputData.getAvailableTimes();
            productUpdateSellerSchedule.updateSellerSchedule(product, availableTimes);

            productUpdateState.updateProductState(product, 2);

            success = true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            SellerSelectScheduleOutputData outputData = new SellerSelectScheduleOutputData(inputData.getSellerName(),
                    inputData.getProductId(), inputData.getAvailableTimes(), success);

            outputBoundary.presentScheduleSelection(outputData);
        }
    }
}

