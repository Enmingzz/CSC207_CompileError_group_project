package use_case.shopping_cart;

import data_access.in_memory.product.InMemoryProductUpdateStateDataAccessObject;
import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
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

class PurchaseInteractorTest {

    private Product product;
    private User user;
    private ArrayList<Product> initialProducts;

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

        initialProducts = new ArrayList<>();
        initialProducts.add(product);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void purchaseProduct() throws SQLException, IOException {


        PurchaseOutputBoundary mockPresenter = new PurchaseOutputBoundary() {
            @Override
            public void prepareSuccessView(PurchaseOutputData response) {
                Product actualProduct = response.getProduct();
                User actualUser = response.getUser();
                assertEquals("username", actualUser.getName());
                assertEquals(actualProduct.getProductID(), initialProducts.get(0).getProductID());
                assertEquals(actualProduct.getDescription(), initialProducts.get(0).getDescription());
                assertEquals(actualProduct.getTitle(), initialProducts.get(0).getTitle());
                assertEquals(actualProduct.getAddress(), initialProducts.get(0).getAddress());
                assertEquals(actualProduct.geteTransferEmail(), initialProducts.get(0).geteTransferEmail());
                assertEquals(actualProduct.getSellerStudentNumber(), initialProducts.get(0).getSellerStudentNumber());
                assertEquals(actualProduct.getPrice(), initialProducts.get(0).getPrice());
                assertEquals(actualProduct.getRating(), initialProducts.get(0).getRating());
                assertEquals(actualProduct.getState(), initialProducts.get(0).getState());
                assertEquals(actualProduct.getState(), 1);
            }
        };

        PurchaseInputData inputData =
                new PurchaseInputData(user, product);

        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessInterface =
                new InMemoryProductUpdateStateDataAccessObject(initialProducts);

        ProductReadByIdDataAccessInterface productReadByIdDataAccessInterface =
                new InMemoryProductReadByIdDataAccessObject(initialProducts);

        PurchaseInteractor interactor = new PurchaseInteractor(productUpdateStateDataAccessInterface,
                productReadByIdDataAccessInterface,
                mockPresenter);

        interactor.purchaseProduct(inputData);


    }
}