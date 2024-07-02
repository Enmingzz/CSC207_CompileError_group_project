package interface_adapter.schedule;
import interface_adapter.ViewManagerModel;
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInputData;

import java.time.LocalDateTime;

public class BuyerSelectScheduleController {
    private BuyerSelectScheduleInputBoundary inputBoundary;
    private ViewManagerModel viewManagerModel;

    public BuyerSelectScheduleController(BuyerSelectScheduleInputBoundary inputBoundary, ViewManagerModel viewManagerModel) {
        this.inputBoundary = inputBoundary;
        this.viewManagerModel = viewManagerModel;
    }

    public void selectSchedule(LocalDateTime selectedTime) {
        String buyerName = viewManagerModel.getBuyerName();
        String productId = viewManagerModel.getProductId();

        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyerName, productId, selectedTime);
        inputBoundary.selectSchedule(inputData);
    }

}
