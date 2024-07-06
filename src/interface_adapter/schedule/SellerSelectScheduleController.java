package interface_adapter.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInputData;
import view.schedule.SellerScheduleView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SellerSelectScheduleController {
    private final SellerSelectScheduleInputBoundary inputBoundary;
    private final SellerSelectScheduleState state;

    public SellerSelectScheduleController(SellerSelectScheduleInputBoundary inputBoundary, SellerSelectScheduleState state) {
        this.inputBoundary = inputBoundary;
        this.state = state;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        state.setSeller(user);
        state.setProduct(product);

        // Open the schedule view
        SellerSelectScheduleViewModel sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        SellerScheduleView sellerScheduleView = new SellerScheduleView(this, sellerSelectScheduleViewModel);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(sellerScheduleView);
        frame.pack();
        frame.setVisible(true);
    }

    public void execute(ArrayList<LocalDateTime> availableTimes) throws SQLException, IOException {
        state.setAvailableTimes(availableTimes);
        SellerSelectScheduleInputData inputData = new SellerSelectScheduleInputData(state.getSeller().getName(), state.getProduct().getProductID(), availableTimes);
        inputBoundary.execute(inputData);
    }
}
