package use_case.shopping_cart;

import entity.product.Product;
import entity.shopping_cart.ShoppingCart;
import entity.user.User;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class AddShoppingCartProductInteractorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.shoppingCartUpdateAddDataAccessObject = shoppingCartUpdateAddDataAccessObject;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
        this.shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObject;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addProductToShoppingCart() {
    }
}