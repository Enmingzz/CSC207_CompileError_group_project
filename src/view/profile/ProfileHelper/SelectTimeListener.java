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

/**
 * SelectTimeListener is an ActionListener that handles the action of selecting a meeting time for a product.
 * This listener interacts with the GetSellerSchedulePageController to display the seller's schedule page.
 */
public class SelectTimeListener implements ActionListener {
    private final GetSellerSchedulePageController getSellerSchedulePageController;
    private final Product product;
    private final User user;

    /**
     * Constructs a SelectTimeListener with the specified schedule page controller, product, and user.
     *
     * @param getSellerSchedulePageController the controller responsible for getting the seller's schedule page
     * @param product                         the product for which the meeting time is being selected
     * @param user                            the user performing the action
     */
    public SelectTimeListener(GetSellerSchedulePageController getSellerSchedulePageController, Product product, User user){
        this.product = product;
        this.getSellerSchedulePageController = getSellerSchedulePageController;
        this.user = user;
    }

    /**
     * Invoked when an action occurs. Executes the action to get the seller's schedule page.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            getSellerSchedulePageController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
