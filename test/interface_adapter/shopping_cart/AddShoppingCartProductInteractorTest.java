package interface_adapter.shopping_cart;

import data_access.in_memory.shopping_cart.InMemoryShoppingCartReadDataAccessObject;
import data_access.in_memory.shopping_cart.InMemoryShoppingCartUpdateAddDataAccessObject;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
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
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.shopping_cart.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddShoppingCartProductInteractorTest {

    private Product product;
    private User user;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() throws IOException {

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        Image image = ImageIO.read(new File("/Users/hanruizhang/Downloads/timetable (2).png"));

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

        float totalPrice = 0;
        ArrayList<Product> listProducts = new ArrayList<>();

        shoppingCart = shoppingCartFactory.createShoppingCart(totalPrice, studentNumber, listProducts);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successfulAddShoppingCart() throws SQLException, IOException {


        AddShoppingCartProductOutputBoundary mockShoppingCartPresenter = new AddShoppingCartProductOutputBoundary() {
            @Override
            public void prepareSuccessView(AddShoppingCartProductOutputData response) {
                ArrayList<Product> actualListProducts = response.getListProducts();
                User actualUser = response.getUser();
                float actualTotalPrice = response.getTotalPrice();

                assertEquals("username", actualUser.getName());
                assertEquals(actualTotalPrice, 1);
                assertEquals(actualListProducts.get(0), product);
            }
        };

        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                new InMemoryShoppingCartReadDataAccessObject();
        ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessObject =
                new InMemoryShoppingCartUpdateAddDataAccessObject();

        AddShoppingCartProductInputData inputData =
                new AddShoppingCartProductInputData(product, user);

        AddShoppingCartProductInputBoundary interactor =
                new AddShoppingCartProductInteractor(shoppingCartUpdateAddDataAccessObject,
                        mockShoppingCartPresenter, shoppingCartReadDataAccessObject);

        interactor.addProductToShoppingCart(inputData);



    }

}