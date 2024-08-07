package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * In-memory implementation of {@link ShoppingCartReadDataAccessInterface} to read shopping cart data.
 */
public class InMemoryShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    /**
     * Constructs an empty in-memory shopping cart data access object.
     */
    public InMemoryShoppingCartReadDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    /**
     * Constructs an in-memory shopping cart data access object with a predefined list of shopping carts.
     *
     * @param shoppingCarts the list of shopping carts to initialize with
     */
    public InMemoryShoppingCartReadDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {

        this.shoppingCarts = shoppingCarts;
    }

    /**
     * Retrieves the shopping cart associated with the specified user ID.
     *
     * @param userID the ID of the user whose shopping cart is to be retrieved
     * @return the shopping cart associated with the specified user ID
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public ShoppingCart getShoppingCart(String userID) throws SQLException, IOException {
        for (ShoppingCart shoppingCart : this.shoppingCarts) {
            if (Objects.equals(shoppingCart.getStudentNumber(), userID)) {
                ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

                ArrayList<Product> outputProducts = new ArrayList<>();
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

                    outputProducts.add(copyProduct);
                }

                ShoppingCart copyShoppingCart =
                        shoppingCartFactory.createShoppingCart(shoppingCart.getTotalPrice(),
                                userID,
                                outputProducts);

                return copyShoppingCart;
            }

        }

        return null;
    }

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
