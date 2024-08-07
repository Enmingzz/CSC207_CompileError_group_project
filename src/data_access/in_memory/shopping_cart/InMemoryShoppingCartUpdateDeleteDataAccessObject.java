package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * In-memory implementation of {@link ShoppingCartUpdateDeleteDataAccessInterface} to update and delete items from shopping carts.
 */
public class InMemoryShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    /**
     * Constructs an empty in-memory shopping cart data access object.
     */
    public InMemoryShoppingCartUpdateDeleteDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    /**
     * Constructs an in-memory shopping cart data access object with a predefined list of shopping carts.
     *
     * @param shoppingCarts the list of shopping carts to initialize with
     */
    public InMemoryShoppingCartUpdateDeleteDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    /**
     * Updates the shopping cart by removing the specified product and adjusting the total price.
     *
     * @param user          the user whose shopping cart is to be updated
     * @param updatedProduct the product to be removed from the shopping cart
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateShoppingCart(User user, Product updatedProduct) throws SQLException {
        for (int i = 0; i < shoppingCarts.size(); i++) {
            if (Objects.equals(shoppingCarts.get(i).getStudentNumber(), user.getStudentNumber())) {
                shoppingCarts.get(i).getListProducts().removeIf(product -> Objects.equals(product.getProductID(), updatedProduct.getProductID()));
                ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
                ShoppingCart newShoppingCart = shoppingCartFactory.createShoppingCart(
                        shoppingCarts.get(i).getTotalPrice() - updatedProduct.getPrice(),
                        user.getStudentNumber(),
                        shoppingCarts.get(i).getListProducts()
                );
                shoppingCarts.set(i, newShoppingCart);
            }

        }
    }
}
