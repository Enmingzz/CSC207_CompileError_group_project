package use_case.shopping_cart;

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

import static org.junit.jupiter.api.Assertions.*;

class AddShoppingCartProductInteractorTest {

    private Product product;
    private Product dupeProduct;
    private User user;
    private ShoppingCart shoppingCart;
    private ShoppingCart shoppingCartDupe;
    private ArrayList<ShoppingCart> initialShoppingCarts;
    private ArrayList<ShoppingCart> initialShoppingCartsDuplicate;

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

        Image image2 = ImageIO.read(new File("src/pic/testpic1.png"));

        String description2 = "This is a description";

        String title2 = "This is a title";

        float price2 = 1;

        Integer rating2 = 0;

        int state2 = 0;

        String eTransferEmail2 = "example@email.com";

        String sellerStudentNumber2 = "1234567890";

        String address2 = "BA 3175";

        ArrayList<String> listTags2 = new ArrayList<>();

        listTags2.add("Tag 1");

        listTags2.add("Tag 2");

        String productID2 = "id_1";

        LocalDateTime buyerTime2 = null;

        ArrayList<LocalDateTime> sellerTime2 = new ArrayList<>();

        Schedule schedule2 = scheduleFactory.createSchedule(buyerTime2, sellerTime2);

        dupeProduct = productFactory.createProduct(
                image2, description2, title2, price2, rating2, state2, eTransferEmail2, sellerStudentNumber2, address2,
                listTags2, productID2, schedule2
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

        ArrayList<Product> newListProducts = new ArrayList<>();
        newListProducts.add(dupeProduct);


        shoppingCart = shoppingCartFactory.createShoppingCart(totalPrice, studentNumber, listProducts);
        shoppingCartDupe = shoppingCartFactory.createShoppingCart(totalPrice, studentNumber, newListProducts);

        initialShoppingCarts = new ArrayList<>();
        initialShoppingCarts.add(shoppingCart);
        initialShoppingCartsDuplicate = new ArrayList<>();
        initialShoppingCartsDuplicate.add(shoppingCartDupe);
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
                assertEquals(actualListProducts.get(0).getImage(), product.getImage());
                assertEquals(actualTotalPrice, initialShoppingCarts.get(0).getTotalPrice());
            }

            @Override
            public void prepareFailedView(String errorMessage) {
                assert(false);

            }
        };

        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                new InMemoryShoppingCartReadDataAccessObject(initialShoppingCarts);
        ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessObject =
                new InMemoryShoppingCartUpdateAddDataAccessObject(initialShoppingCarts);

        AddShoppingCartProductInputData inputData =
                new AddShoppingCartProductInputData(product, user);

        AddShoppingCartProductInputBoundary interactor =
                new AddShoppingCartProductInteractor(shoppingCartUpdateAddDataAccessObject,
                        mockShoppingCartPresenter, shoppingCartReadDataAccessObject);

        interactor.addProductToShoppingCart(inputData);



    }

    @Test
    void duplicationFailedAddShoppingCart() throws SQLException, IOException {


        AddShoppingCartProductOutputBoundary mockShoppingCartPresenter = new AddShoppingCartProductOutputBoundary() {
            @Override
            public void prepareSuccessView(AddShoppingCartProductOutputData response) {
                assert false;
            }

            @Override
            public void prepareFailedView(String errorMessage) {
               assertEquals("Product already in Shopping Cart", errorMessage);

            }
        };

        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                new InMemoryShoppingCartReadDataAccessObject(initialShoppingCartsDuplicate);
        ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessObject =
                new InMemoryShoppingCartUpdateAddDataAccessObject(initialShoppingCartsDuplicate);

        AddShoppingCartProductInputData inputData =
                new AddShoppingCartProductInputData(product, user);

        AddShoppingCartProductInputBoundary interactor =
                new AddShoppingCartProductInteractor(shoppingCartUpdateAddDataAccessObject,
                        mockShoppingCartPresenter, shoppingCartReadDataAccessObject);

        interactor.addProductToShoppingCart(inputData);



    }

}