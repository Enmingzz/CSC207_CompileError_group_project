package use_case.shopping_cart;

import data_access.in_memory.shopping_cart.InMemoryShoppingCartReadDataAccessObject;
import data_access.in_memory.shopping_cart.InMemoryShoppingCartUpdateAddDataAccessObject;
import data_access.in_memory.shopping_cart.InMemoryShoppingCartUpdateDeleteDataAccessObject;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
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
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteShoppingCartProductInteractorTest {

    private Product product;
    private User user;
    private ShoppingCart shoppingCart;
    private ArrayList<ShoppingCart> initialShoppingCarts;

    @BeforeEach
    void setUp() throws IOException {

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));

        String description = "This is a description";

        String title = "This is a title";

        float price = 1;

        Integer rating = 0;

        int state = 0;

        String eTransferEmail = "example@email.com";

        String sellerStudentNumber = "1234567890";

        String address = "BA 3175";

        ArrayList<String> listTags = new ArrayList<>();

        listTags.add("Tag 1");

        listTags.add("Tag 2");

        String productID = "id_1";

        LocalDateTime buyerTime = null;

        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();

        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);

        product = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        UserFactory userFactory = new CommonUserFactory();

        String name = "username";
        String password = "password";
        String email = "example@email.com";
        float userRating = 0;
        String studentNumber = "1234567890";

        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

        ArrayList<Product> listProducts = new ArrayList<>();
        float totalPrice = product.getPrice();
        listProducts.add(product);

        shoppingCart = shoppingCartFactory.createShoppingCart(totalPrice, studentNumber, listProducts);

        initialShoppingCarts = new ArrayList<>();
        initialShoppingCarts.add(shoppingCart);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteShoppingCartProduct() throws SQLException, IOException {


        DeleteShoppingCartProductOutputBoundary mockShoppingCartPresenter = new DeleteShoppingCartProductOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteShoppingCartProductOutputData response) {
                ArrayList<Product> actualListProducts = response.getListProducts();
                User actualUser = response.getUser();
                float actualTotalPrice = response.getTotalPrice();

                assertEquals("username", actualUser.getName());
                assertEquals(actualTotalPrice, 0);
                assertEquals(actualListProducts.size(), 0);;

                assertEquals(initialShoppingCarts.get(0).getListProducts().size(), 0);
            }
        };

        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                new InMemoryShoppingCartReadDataAccessObject(initialShoppingCarts);
        ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessObject =
                new InMemoryShoppingCartUpdateDeleteDataAccessObject(initialShoppingCarts);

        DeleteShoppingCartProductInputData inputData =
                new DeleteShoppingCartProductInputData(user, product);

        DeleteShoppingCartProductInputBoundary interactor =
                new DeleteShoppingCartProductInteractor(shoppingCartUpdateDeleteDataAccessObject,
                        shoppingCartReadDataAccessObject, mockShoppingCartPresenter);

        interactor.deleteShoppingCartProduct(inputData);



    }


}