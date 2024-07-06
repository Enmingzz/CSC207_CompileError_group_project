package view.profile.ProfileListener;

import entity.product.Product;
import interface_adapter.modify_product.ModifyProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyProductListener implements ActionListener {
    private final ModifyProductController modifyProductController;
    private final Product product;

    public ModifyProductListener(ModifyProductController modifyProductController, Product product){
        this.modifyProductController = modifyProductController;
        this.product = product;
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        try {
//            modifyProductController.execute(product);
//        } catch (SQLException | IOException ex) {
//            throw new RuntimeException(ex);
//        }
        System.out.println("modifyProductController.execute(product)");
    }
}
