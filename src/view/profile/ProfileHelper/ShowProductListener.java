package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.view_product.ViewProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowProductListener implements ActionListener {
    private final ViewProductController viewProductController;
    private final Product product;
    private final User user;

    public ShowProductListener(ViewProductController viewProductController, Product product, User user){
        this.product = product;
        this.viewProductController = viewProductController;
        this.user = user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            viewProductController.execute(product, user);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
