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

public class InMemoryShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    public InMemoryShoppingCartUpdateDeleteDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    public InMemoryShoppingCartUpdateDeleteDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @Override
    public void updateShoppingCart(User user, Product updatedProduct) throws SQLException {
        for (ShoppingCart shoppingCart : this.shoppingCarts) {
            if (Objects.equals(shoppingCart.getStudentNumber(), user.getStudentNumber())) {
                for (Product product : shoppingCart.getListProducts()) {
                    if (Objects.equals(product.getProductID(), updatedProduct.getProductID())) {
                        shoppingCart.getListProducts().remove(product);
                    }

                }
            }

        }
    }
}
