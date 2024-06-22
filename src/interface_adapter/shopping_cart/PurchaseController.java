package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import use_case.shopping_cart.PurchaseInputData;
import use_case.shopping_cart.PurchaseInputBoundary;

import java.io.IOException;
import java.sql.SQLException;

public class PurchaseController{
    final PurchaseInputBoundary purchaseInteractor;

    public PurchaseController(PurchaseInputBoundary purchaseInteractor){
        this.purchaseInteractor = purchaseInteractor;
    }

    public void execute(User user, Product product) throws SQLException, IOException {
        PurchaseInputData purchaseInputData = new PurchaseInputData(user, product);

        purchaseInteractor.purchaseProduct(purchaseInputData);
    }
}
