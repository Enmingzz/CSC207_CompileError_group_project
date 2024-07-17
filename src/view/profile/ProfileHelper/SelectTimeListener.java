package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.schedule.GetSellerSchedulePageController;
import interface_adapter.schedule.SellerSelectScheduleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SelectTimeListener implements ActionListener {
    private final GetSellerSchedulePageController getSellerSchedulePageController;
    private final Product product;
    private final User user;

    public SelectTimeListener(GetSellerSchedulePageController getSellerSchedulePageController, Product product, User user){
        this.product = product;
        this.getSellerSchedulePageController = getSellerSchedulePageController;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            getSellerSchedulePageController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
