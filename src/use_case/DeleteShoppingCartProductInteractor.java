package use_case;

import entity.product.Product;
import entity.user.User;

import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.interfaces.ShoppingCartReadDataAccessInterface;

import java.sql.SQLException;


public class DeleteShoppingCartProductInteractor implements DeleteShoppingCartProductInputBoundary {
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface;
    final ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessInterface;
    final DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData;

    public DeleteShoppingCartProductInteractor(ShoppingCartUpdateDeleteDataAccessInterface
                                                       shoppingCartUpdateDeleteDataAccessInterface,
                                               ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface,
                                               DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData)
    {
        this.shoppingCartReadDataAccessInterface = shoppingCartReadDataAccessInterface;
        this.shoppingCartUpdateDeleteDataAccessInterface = shoppingCartUpdateDeleteDataAccessInterface;
        this.deleteShoppingCartProductOutputData = deleteShoppingCartProductOutputData;
    }

    @Override
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException{
        User user = deleteShoppingCartProductInputData.getUser();
        Product deletedProduct = deleteShoppingCartProductInputData.getProduct();

        DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData = new DeleteShoppingCartProductOutputData(user);
        shoppingCartUpdateDeleteDataAccessInterface.updateShoppingCart(user, deletedProduct);

    }
}
