package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.modify.ViewModifyProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ModifyProductListener is an ActionListener that handles the action of modifying a product.
 */
public class ModifyProductListener implements ActionListener {
    private final ViewModifyProductController viewModifyProductController;
    private final Product product;
    private final User user;

    /**
     * Constructs a ModifyProductListener with the specified view modify product controller, product, and user.
     *
     * @param viewModifyProductController the controller responsible for modifying the product
     * @param product                     the product to be modified
     * @param user                        the user performing the modify action
     */
    public ModifyProductListener(ViewModifyProductController viewModifyProductController, Product product, User user){
        this.viewModifyProductController = viewModifyProductController;
        this.product = product;
        this.user = user;
    }

    /**
     * Invoked when an action occurs. Executes the modify product action.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            viewModifyProductController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
