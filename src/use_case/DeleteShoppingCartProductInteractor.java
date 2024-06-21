package use_case;

import entity.product.Product;
import entity.shopping_cart.ShoppingCart;
import entity.user.User;

import data_access.interfaces.ShoppingCartUpdateAddDataAccessInterface;
import data_access.interfaces.ShoppingCartReadDataAccessInterface;

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
