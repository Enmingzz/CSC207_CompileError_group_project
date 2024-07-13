package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BuyerSelectScheduleController {
    private BuyerSelectScheduleInputBoundary inputBoundary;


    public BuyerSelectScheduleController(BuyerSelectScheduleInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }


    public void execute(User buyer, Product product, LocalDateTime selectedTime) throws SQLException, IOException {
        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyer, product, selectedTime);
        inputBoundary.execute(inputData);
    }

}
