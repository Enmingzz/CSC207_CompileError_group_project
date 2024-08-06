package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.view_product.ViewProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * ShowProductListener is an ActionListener that handles the action of displaying a product's details.
 * This listener interacts with the ViewProductController to display the product.
 */
public class ShowProductListener implements ActionListener {
    private final ViewProductController viewProductController;
    private final Product product;
    private final User user;

    /**
     * Constructs a ShowProductListener with the specified view product controller, product, and user.
     *
     * @param viewProductController the controller responsible for viewing the product
     * @param product               the product to be viewed
     * @param user                  the user performing the action
     */
    public ShowProductListener(ViewProductController viewProductController, Product product, User user){
        this.product = product;
        this.viewProductController = viewProductController;
        this.user = user;
    }

    /**
     * Invoked when an action occurs. Executes the view product action by calling the appropriate method in the controller.
     * It also handles potential SQL exceptions by throwing a RuntimeException.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            viewProductController.execute(product, user);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
