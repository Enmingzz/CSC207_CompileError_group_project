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

public class InMemoryShoppingCartCreateDataAccessObject implements ShoppingCartCreateDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    public InMemoryShoppingCartCreateDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    public InMemoryShoppingCartCreateDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {

        this.shoppingCarts = new ArrayList<>();

        for (ShoppingCart shoppingCart : shoppingCarts) {
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
                            shoppingCart.getStudentNumber(),
                            outputProducts);

            this.shoppingCarts.add(copyShoppingCart);

        }
    }

    @Override
    public void saveShoppingCart(User user) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

        ShoppingCart shoppingCart =
                shoppingCartFactory.createShoppingCart(0, user.getStudentNumber(), new ArrayList<>());

        this.shoppingCarts.add(shoppingCart);
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
