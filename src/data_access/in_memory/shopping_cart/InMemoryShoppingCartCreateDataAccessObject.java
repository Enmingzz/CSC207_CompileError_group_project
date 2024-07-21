package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
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
 * In-memory implementation of {@link ShoppingCartCreateDataAccessInterface} to create and manage shopping carts.
 */
public class InMemoryShoppingCartCreateDataAccessObject implements ShoppingCartCreateDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    /**
     * Constructs an empty in-memory shopping cart data access object.
     */
    public InMemoryShoppingCartCreateDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    /**
     * Constructs an in-memory shopping cart data access object with a predefined list of shopping carts.
     *
     * @param shoppingCarts the list of shopping carts to initialize with
     */
    public InMemoryShoppingCartCreateDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    /**
     * Saves a new shopping cart for the given user.
     *
     * @param user the user for whom the shopping cart is to be saved
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void saveShoppingCart(User user) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

        ShoppingCart shoppingCart =
                shoppingCartFactory.createShoppingCart(0, user.getStudentNumber(), new ArrayList<>());

        this.shoppingCarts.add(shoppingCart);
    }

    /**
     * Retrieves all shopping carts.
     *
     * @return a list of all shopping carts
     */
    public ArrayList<ShoppingCart> getAllShoppingCarts() {

        ArrayList<ShoppingCart> copyAllCarts = new ArrayList<>();
        for (ShoppingCart shoppingCart : this.shoppingCarts) {

            ArrayList<Product> shoppingCartProducts = new ArrayList<>();

            for (Product product : shoppingCart.getListProducts()) {
                ProductFactory productFactory = new CommonProductFactory();
                ArrayList<String> copyListTags = new ArrayList<>();
                for (String tag : product.getListTags()) {
                    copyListTags.add(tag);
                }

                Schedule schedule = product.getSchedule();
                ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
                for (LocalDateTime sellerTime : schedule.getSellerTime()) {
                    sellerTimes.add(sellerTime);
                }
                ScheduleFactory scheduleFactory = new CommonScheduleFactory();
                Schedule copySchedule = scheduleFactory.createSchedule(schedule.getBuyerTime(),
                        sellerTimes);
                Product copyProduct = productFactory.createProduct(product.getImage(),
                        product.getDescription(),
                        product.getTitle(),
                        product.getPrice(),
                        product.getRating(),
                        product.getState(),
                        product.geteTransferEmail(),
                        product.getSellerStudentNumber(),
                        product.getAddress(),
                        copyListTags,
                        product.getProductID(),
                        copySchedule);

                shoppingCartProducts.add(copyProduct);
            }

            ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

            ShoppingCart copyShoppingCart = shoppingCartFactory.createShoppingCart(shoppingCart.getTotalPrice(),
                    shoppingCart.getStudentNumber(),
                    shoppingCartProducts);

            copyAllCarts.add(copyShoppingCart);

        }
        return copyAllCarts;
    }
}
