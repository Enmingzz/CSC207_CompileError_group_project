package interface_adapter.schedule;


import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class SellerSelectScheduleController {
    private final SellerSelectScheduleInputBoundary inputBoundary;

    public SellerSelectScheduleController(SellerSelectScheduleInputBoundary inputBoundary, SellerSelectScheduleState state) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(String sellerName, String productId, ArrayList<LocalDateTime> availableTimes) throws SQLException, IOException {
        SellerSelectScheduleInputData inputData = new SellerSelectScheduleInputData(sellerName, productId, availableTimes);
        inputBoundary.execute(inputData);
    }
}
