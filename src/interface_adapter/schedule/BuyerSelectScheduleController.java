package interface_adapter.schedule;

import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BuyerSelectScheduleController {
    private BuyerSelectScheduleInputBoundary inputBoundary;


    public BuyerSelectScheduleController(BuyerSelectScheduleInputBoundary inputBoundary, BuyerSelectScheduleState state) {
        this.inputBoundary = inputBoundary;
    }


    public void execute(String buyerName, String productId,LocalDateTime selectedTime) throws SQLException, IOException {
        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyerName, productId, selectedTime);
        inputBoundary.execute(inputData);
    }

}
