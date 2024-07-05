package view.profile.ProfileListener;

import entity.product.Product;
import interface_adapter.modify_product.DeleteProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductListener implements ActionListener {
    private final DeleteProductController deleteProductController;
    private final Product product;

    public DeleteProductListener(DeleteProductController deleteProductController, Product product){
        this.deleteProductController = deleteProductController;
        this.product = product;
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        try {
//            modifyProductController.execute(product);
//        } catch (SQLException | IOException ex) {
//            throw new RuntimeException(ex);
//        }
        System.out.println("deleteProductController.execute(product)");
    }
}
