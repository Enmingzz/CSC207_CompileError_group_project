package data_access.in_memory.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
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

public class InMemoryShoppingCartUpdateAddDataAccessObject implements ShoppingCartUpdateAddDataAccessInterface {

    private ArrayList<ShoppingCart> shoppingCarts;

    public InMemoryShoppingCartUpdateAddDataAccessObject() {
        this.shoppingCarts = new ArrayList<>();
    }

    public InMemoryShoppingCartUpdateAddDataAccessObject(ArrayList<ShoppingCart> shoppingCarts) {

        this.shoppingCarts = shoppingCarts;
    }

    @Override
    public void updateShoppingCart(User user, Product updatedProduct) throws SQLException {
        for (int i = 0; i< shoppingCarts.size(); i++) {

            if (Objects.equals(shoppingCarts.get(i).getStudentNumber(), user.getStudentNumber())) {

                ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

                ArrayList<Product> updatedProducts = shoppingCarts.get(i).getListProducts();

                ProductFactory productFactory = new CommonProductFactory();

                ArrayList<String> copyListTags = new ArrayList<>();
                for (String tag : updatedProduct.getListTags()) {
                    copyListTags.add(tag);
                }

                Schedule schedule = updatedProduct.getSchedule();
                ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
                for (LocalDateTime sellerTime : schedule.getSellerTime()) {
                    sellerTimes.add(sellerTime);
                }
                ScheduleFactory scheduleFactory = new CommonScheduleFactory();
                Schedule copySchedule = scheduleFactory.createSchedule(schedule.getBuyerTime(),
                        sellerTimes);
                Product copyProduct = productFactory.createProduct(updatedProduct.getImage(),
                        updatedProduct.getDescription(),
                        updatedProduct.getTitle(),
                        updatedProduct.getPrice(),
                        updatedProduct.getRating(),
                        updatedProduct.getState(),
                        updatedProduct.geteTransferEmail(),
                        updatedProduct.getSellerStudentNumber(),
                        updatedProduct.getAddress(),
                        copyListTags,
                        updatedProduct.getProductID(),
                        copySchedule);

                updatedProducts.add(copyProduct);

                ShoppingCart updatedShoppingCart = shoppingCartFactory.createShoppingCart(
                        shoppingCarts.get(i).getTotalPrice() + updatedProduct.getPrice(),
                        user.getStudentNumber(),
                        updatedProducts
                );

                shoppingCarts.set(i, updatedShoppingCart);
            }



        }
    }




}
