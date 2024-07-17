package interface_adapter.schedule;


import entity.product.Product;
import entity.user.User;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInputData;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The SellerSelectScheduleController class handles the request to select a schedule for a seller.
 * It interacts with the use case layer to perform the necessary operations.
 */
public class SellerSelectScheduleController {
    private final SellerSelectScheduleInputBoundary inputBoundary;

    /**
     * Constructs a SellerSelectScheduleController.
     *
     * @param inputBoundary the input boundary to handle the seller select schedule use case
     */
    public SellerSelectScheduleController(SellerSelectScheduleInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Executes the process of selecting a schedule for the given seller, product, and available times.
     *
     * @param seller the seller selecting the schedule
     * @param product the product associated with the schedule
     * @param availableTimes the available schedule times
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public void execute(User seller, Product product, ArrayList<LocalDateTime> availableTimes) throws SQLException, IOException {
        SellerSelectScheduleInputData inputData = new SellerSelectScheduleInputData(seller, product, availableTimes);
        inputBoundary.execute(inputData);
    }
}
