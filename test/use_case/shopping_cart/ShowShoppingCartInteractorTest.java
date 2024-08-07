package use_case.shopping_cart;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.shopping_cart.InMemoryShoppingCartReadDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
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

class ShowShoppingCartInteractorTest {

    private Product product;
    private User user;
    private ShoppingCart shoppingCart;
    private ArrayList<ShoppingCart> initialShoppingCarts;
    private ArrayList<Product> initialProducts = new ArrayList<>();

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

        float totalPrice = 1;
        ArrayList<Product> listProducts = new ArrayList<>();
        listProducts.add(product);
        initialProducts.add(product);

        shoppingCart = shoppingCartFactory.createShoppingCart(totalPrice, studentNumber, listProducts);

        initialShoppingCarts = new ArrayList<>();
        initialShoppingCarts.add(shoppingCart);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException, IOException {
        ShowShoppingCartOutputBoundary mockPresenter = new ShowShoppingCartOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ShowShoppingCartOutputData response) {
                ShoppingCart actualShoppingCart = response.getShoppingCart();
                ArrayList<Product> actualListProducts = actualShoppingCart.getListProducts();
                User actualUser = response.getUser();
                float actualTotalPrice = actualShoppingCart.getTotalPrice();
                assertEquals("username", actualUser.getName());
                assertEquals(actualTotalPrice, 1);
                assertEquals(actualListProducts.size(), 1);
                assertEquals(actualListProducts.get(0).getProductID(), product.getProductID());
                assertEquals(actualListProducts.get(0).getDescription(), product.getDescription());
                assertEquals(actualListProducts.get(0).getTitle(), product.getTitle());
                assertEquals(actualListProducts.get(0).getAddress(), product.getAddress());
                assertEquals(actualListProducts.get(0).geteTransferEmail(), product.geteTransferEmail());
                assertEquals(actualListProducts.get(0).getSellerStudentNumber(), product.getSellerStudentNumber());
                assertEquals(actualListProducts.get(0).getPrice(), product.getPrice());
                assertEquals(actualListProducts.get(0).getRating(), product.getRating());
                assertEquals(actualListProducts.get(0).getState(), product.getState());

            }
        };

        ShowShoppingCartInputData inputData =
                new ShowShoppingCartInputData(user);

        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface =
                new InMemoryShoppingCartReadDataAccessObject(initialShoppingCarts);

        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject = new InMemoryProductReadByIdDataAccessObject(initialProducts);

        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();

        ShowShoppingCartInteractor interactor =
                new ShowShoppingCartInteractor(mockPresenter, shoppingCartReadDataAccessInterface, productReadByIdDataAccessObject, shoppingCartFactory);
        interactor.execute(inputData);
    }
}