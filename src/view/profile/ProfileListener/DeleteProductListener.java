package view.profile.ProfileListener;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.DeleteProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteProductListener implements ActionListener {
    private final DeleteProductController deleteProductController;
    private final Product product;
    private final User user;

    public DeleteProductListener(DeleteProductController deleteProductController, Product product, User user){
        this.deleteProductController = deleteProductController;
        this.product = product;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            deleteProductController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
