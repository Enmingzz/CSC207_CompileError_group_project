package use_case.schedule;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.sql.SQLException;
import java.io.IOException;

public class BuyerSelectScheduleInteractor implements BuyerSelectScheduleInputBoundary {
    private BuyerSelectScheduleOutputBoundary outputBoundary;
    private ProductReadByIdDataAccessInterface productReadById;
    private ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerSchedule;
    private ProductUpdateStateDataAccessInterface productUpdateState;

    public BuyerSelectScheduleInteractor(BuyerSelectScheduleOutputBoundary outputBoundary,
                                         ProductReadByIdDataAccessInterface productReadById,
                                         ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerSchedule,
                                         ProductUpdateStateDataAccessInterface productUpdateState) {
        this.outputBoundary = outputBoundary;
        this.productReadById = productReadById;
        this.productUpdateBuyerSchedule = productUpdateBuyerSchedule;
        this.productUpdateState = productUpdateState;
    }

    @Override
    public void selectSchedule(BuyerSelectScheduleInputData inputData) {
        boolean success = false;
        try{
            Product product = productReadById.getProductById(inputData.getProductId());
            productUpdateBuyerSchedule.updateBuyerScheduleByProductID(product, inputData.getSelectedTime());

            productUpdateState.updateProductState(product, 3);

            success = true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            BuyerSelectScheduleOutputData outputData = new BuyerSelectScheduleOutputData(inputData.getBuyerName(),
                    inputData.getProductId(), inputData.getSelectedTime(), success);
            outputBoundary.presentScheduleSelection(outputData);
        }
    }
}
