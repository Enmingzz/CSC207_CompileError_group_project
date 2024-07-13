package interface_adapter.schedule;


import entity.product.Product;
import entity.user.User;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class SellerSelectScheduleController {
    private final SellerSelectScheduleInputBoundary inputBoundary;

    public SellerSelectScheduleController(SellerSelectScheduleInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(User seller, Product product, ArrayList<LocalDateTime> availableTimes) throws SQLException, IOException {
        SellerSelectScheduleInputData inputData = new SellerSelectScheduleInputData(seller, product, availableTimes);
        inputBoundary.execute(inputData);
    }
}
