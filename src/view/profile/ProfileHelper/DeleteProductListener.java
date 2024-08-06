package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.delete.DeleteProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * DeleteProductListener is an ActionListener that handles the deletion of a product.
 */
public class DeleteProductListener implements ActionListener {
    private final DeleteProductController deleteProductController;
    private final Product product;
    private final User user;

    /**
     * Constructs a DeleteProductListener with the specified delete product controller, product, and user.
     *
     * @param deleteProductController the controller responsible for deleting the product
     * @param product                 the product to be deleted
     * @param user                    the user performing the delete action
     */
    public DeleteProductListener(DeleteProductController deleteProductController, Product product, User user){
        this.deleteProductController = deleteProductController;
        this.product = product;
        this.user = user;
    }

    /**
     * Invoked when an action occurs. Executes the delete product action.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            deleteProductController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
