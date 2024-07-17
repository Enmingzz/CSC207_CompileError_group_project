package view.profile.ProfileHelper;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.ViewModifyProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ModifyProductListener implements ActionListener {
    private final ViewModifyProductController viewModifyProductController;
    private final Product product;
    private final User user;

    public ModifyProductListener(ViewModifyProductController viewModifyProductController, Product product, User user){
        this.viewModifyProductController = viewModifyProductController;
        this.product = product;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            viewModifyProductController.execute(user, product);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
