package use_case.rate_product;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateRatingDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateStateDataAccessObject;
import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
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

import static org.junit.Assert.assertEquals;

public class RateProductInteractorTest {
    /** the process for testing is:
     * intoduce input data specifications
     * consider if need to store anything in data base, then use those InMemory to create Data Access Interfaces
     * Create OutputBoundary (overriding methods): insert assertions here
     * Create The Interactor
     * test Interactor.exectue with initated input data
     */
    private User user;
    private Product product;
    private String productRating;
    private ArrayList<Product> productsList;
    private String productID;
    private ArrayList<User> usersList;
    private String studentNumber;
    private UserFactory userFactory;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Samoyed";
        String password = "dog123";
        String email = "samoyed.dog@mail.utoronto.ca";
        float userRating = 5;
        studentNumber = "12345678";

        userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        usersList = new ArrayList<>();
        usersList.add(user);

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String description = "It was worn once";
        float price = 2;
        String title = "Red Dress";
        int state = 1;
        Integer rating = 3;
        String eTransferEmail = "calico.cat@mail.utoronto.ca";
        String sellerStudentNumber = "1010101010";
        String address = "123College";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("clothes");
        String productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();
        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        productsList = new ArrayList<>();
        productsList.add(product);


    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void prepareSuccessfulViewTest() throws IOException, SQLException {
        //The case that the rating is successfully created
        productRating = "1";
        int productRatingInt = Integer.parseInt(productRating);
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        UserReadDataAccessInterface inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(usersList, userFactory);

        RateProductOutputBoundary rateProductPresenter = new RateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) throws SQLException, IOException {
                //check if the state and the product rating are both successfully modified
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getRating(), productRating);
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getState(), -1);
                //Now check if the output data are correct
                assertEquals(rateProductOutputData.getProduct(), inMemoryProductReadByIdDataAccessObject.getProductById(productID));
                assertEquals(rateProductOutputData.getUser(), user);
            }

            @Override
            public void prepareFailedView(String error) {
                assert(false);
            }
        };

        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject = new InMemoryProductUpdateStateDataAccessObject(productsList);
        ProductUpdateRatingDataAccessInterface inMemoryProductUpdateRatingDataAccessObject = new InMemoryProductUpdateRatingDataAccessObject(productsList);

        RateProductInteractor rateProductInteractor = new RateProductInteractor(inMemoryProductUpdateRatingDataAccessObject, inMemoryProductUpdateStateDataAccessObject,
                rateProductPresenter);

        RateProductInputData inputData = new RateProductInputData(user, productRating, product);
        rateProductInteractor.execute(inputData);
    }

    @Test
    void prepareFailedView1() throws IOException, SQLException {
        //The case where the rating provided is not an integer
        productRating = "1.4";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        RateProductOutputBoundary rateProductPresenter = new RateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) throws SQLException, IOException {
                assert(false);
            }

            @Override
            public void prepareFailedView(String error) throws SQLException, IOException {
                //check if the state and the product rating are both unchanged
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getRating(), null);
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getState(), 4);
                //Now check if the error mesage is correct
                assertEquals(error, "You must input a valid integral rating from 1 to 5.");
            }
        };

        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject = new InMemoryProductUpdateStateDataAccessObject(productsList);
        ProductUpdateRatingDataAccessInterface inMemoryProductUpdateRatingDataAccessObject = new InMemoryProductUpdateRatingDataAccessObject(productsList);

        RateProductInteractor rateProductInteractor = new RateProductInteractor(inMemoryProductUpdateRatingDataAccessObject, inMemoryProductUpdateStateDataAccessObject,
                rateProductPresenter);

        RateProductInputData inputData = new RateProductInputData(user, productRating, product);
        rateProductInteractor.execute(inputData);
    }
    @Test
    void prepareFailedView2() throws IOException, SQLException {
        //The case where the rating provided is an integer that is out of the range
        productRating = "6";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        RateProductOutputBoundary rateProductPresenter = new RateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(RateProductOutputData rateProductOutputData) throws SQLException, IOException {
                assert(false);
            }

            @Override
            public void prepareFailedView(String error) throws SQLException, IOException {
                //check if the state and the product rating are both unchanged
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getRating(), null);
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(productID).getState(), 4);
                //Now check if the error message is correct
                assertEquals(error, "You must input a valid integral rating from 1 to 5.");
            }
        };

        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject = new InMemoryProductUpdateStateDataAccessObject(productsList);
        ProductUpdateRatingDataAccessInterface inMemoryProductUpdateRatingDataAccessObject = new InMemoryProductUpdateRatingDataAccessObject(productsList);

        RateProductInteractor rateProductInteractor = new RateProductInteractor(inMemoryProductUpdateRatingDataAccessObject, inMemoryProductUpdateStateDataAccessObject,
                rateProductPresenter);

        RateProductInputData inputData = new RateProductInputData(user, productRating, product);
        rateProductInteractor.execute(inputData);
    }
}
