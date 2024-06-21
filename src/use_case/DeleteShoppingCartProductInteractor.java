package use_case;

import entity.Product;
import entity.ShoppingCart;
import entity.User;

import data_access.ShoppingCartUpdateDataAccessInterface;
import data_access.ShoppingCartReadDataAccessInterface;

import java.sql.SQLException;


public class DeleteShoppingCartProductInteractor implements DeleteShoppingCartProductInputBoundary {
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface;
    final ShoppingCartUpdateDataAccessInterface shoppingCartUpdateDataAccessInterface;
    final DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData;

    public DeleteShoppingCartProductInteractor(ShoppingCartUpdateDataAccessInterface
                                                       shoppingCartUpdateDataAccessInterface,
                                               ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface,
                                               DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData)
    {
        this.shoppingCartReadDataAccessInterface = shoppingCartReadDataAccessInterface;
        this.shoppingCartUpdateDataAccessInterface = shoppingCartUpdateDataAccessInterface;
        this.deleteShoppingCartProductOutputData = deleteShoppingCartProductOutputData;
    }

    @Override
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException{
        User user = deleteShoppingCartProductInputData.getUser();
        Product product = deleteShoppingCartProductInputData.getProduct();



    }
}
