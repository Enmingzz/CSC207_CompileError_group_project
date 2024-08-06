package interface_adapter.schedule.buyer_select_schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleController class handles the request to select a schedule for a buyer.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class BuyerSelectScheduleController {
    private final BuyerSelectScheduleInputBoundary inputBoundary;

    /**
     * Constructs a BuyerSelectScheduleController with the specified input boundary.
     *
     * @param inputBoundary the input boundary to handle the buyer select schedule use case
     */
    public BuyerSelectScheduleController(BuyerSelectScheduleInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }


    /**
     * Executes the process of selecting a schedule for the buyer.
     *
     * @param buyer the buyer selecting the schedule
     * @param product the product associated with the schedule
     * @param selectedTime the selected schedule time
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User buyer, Product product, LocalDateTime selectedTime) throws SQLException, IOException {
        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(buyer, product, selectedTime);
        inputBoundary.execute(inputData);
    }

}
