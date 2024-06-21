package use_case;

import entity.Product;
import entity.ShoppingCart;
import entity.User;

import data_access.ShoppingCartUpdateAddDataAccessInterface;
import data_access.ShoppingCartReadDataAccessInterface;

import java.sql.SQLException;


public class DeleteShoppingCartProductInteractor implements DeleteShoppingCartProductInputBoundary {
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface;
    final ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessInterface;
    final DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData;

    public DeleteShoppingCartProductInteractor(ShoppingCartUpdateAddDataAccessInterface
                                                       shoppingCartUpdateAddDataAccessInterface,
                                               ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface,
                                               DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData)
    {
        this.shoppingCartReadDataAccessInterface = shoppingCartReadDataAccessInterface;
        this.shoppingCartUpdateAddDataAccessInterface = shoppingCartUpdateAddDataAccessInterface;
        this.deleteShoppingCartProductOutputData = deleteShoppingCartProductOutputData;
    }

    @Override
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException{
        User user = deleteShoppingCartProductInputData.getUser();
        Product product = deleteShoppingCartProductInputData.getProduct();
        ShoppingCart shoppingCart = shoppingCartReadDataAccessInterface.getShoppingCart(user);

    }
}
