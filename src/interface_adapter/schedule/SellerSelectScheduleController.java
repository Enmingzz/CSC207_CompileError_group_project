package interface_adapter.schedule;

import interface_adapter.ViewManagerModel;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInputData;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleController {
    private SellerSelectScheduleInputBoundary intputBoundary;
    private ViewManagerModel viewManagerModel;

    public SellerSelectScheduleController(SellerSelectScheduleInputBoundary inputBoundary, ViewManagerModel viewManagerModel) {
        this.intputBoundary = inputBoundary;
        this.viewManagerModel = viewManagerModel;
    }

    public void selectSchedule(ArrayList<LocalDateTime> availableTimes) {
        String sellerName = viewManagerModel.getSellerName();
        String productId = viewManagerModel.getProductId();

        SellerSelectScheduleInputData inputData = new SellerSelectScheduleInputData(sellerName, productId, availableTimes);
        intputBoundary.selectSchedule(inputData);
    }
}
