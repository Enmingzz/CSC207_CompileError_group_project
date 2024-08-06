package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartStateTest {

    private ShoppingCartState shoppingCartState;

    @BeforeEach
    void setUp() {
        shoppingCartState = new ShoppingCartState();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        shoppingCartState.getUser();
    }

    @Test
    void setUser() {
        User user = new CommonUser("hanrui", "123", "@mail", 1, "");
    }

    @Test
    void getListProducts() {
        shoppingCartState.getListProducts();
    }

    @Test
    void setListProducts() {
        ArrayList<Product> products = new ArrayList<>();
        shoppingCartState.setListProducts(products);
    }

    @Test
    void getTotalPrice() {
        assertEquals(0, shoppingCartState.getTotalPrice());
    }

    @Test
    void setTotalPrice() {
        shoppingCartState.setTotalPrice(0);
    }
}