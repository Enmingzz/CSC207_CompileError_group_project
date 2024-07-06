package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInputData;
import view.schedule.BuyerScheduleView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BuyerSelectScheduleController {
    private BuyerSelectScheduleInputBoundary inputBoundary;
    private final BuyerSelectScheduleState state;


    public BuyerSelectScheduleController(BuyerSelectScheduleInputBoundary inputBoundary, BuyerSelectScheduleState state) {
        this.inputBoundary = inputBoundary;
        this.state = state;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        state.setBuyer(user);
        state.setProduct(product);

        // Open the schedule view
        BuyerSelectScheduleViewModel buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();
        BuyerScheduleView buyerScheduleView = new BuyerScheduleView( buyerSelectScheduleViewModel, this);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(buyerScheduleView);
        frame.pack();
        frame.setVisible(true);
    }

    public void execute(LocalDateTime selectedTime) throws SQLException, IOException {
        state.setSelectedTime(selectedTime);
        BuyerSelectScheduleInputData inputData = new BuyerSelectScheduleInputData(state.getBuyer().getName(), state.getProduct().getProductID(), selectedTime);
        inputBoundary.execute(inputData);
    }

}
