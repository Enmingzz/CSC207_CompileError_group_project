package use_case.modify_product;

import static org.junit.jupiter.api.Assertions.*;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateDescriptionDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdatePictureDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdatePriceDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUser;
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

class ChangeProductInteractorTest {
    private User user;
    private String changedDescription ;
    private String changedPrice;
    private Product product;
    private ArrayList<Product> productsList;
    private String productID;


    @BeforeEach
    void setUp() throws IOException {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

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
        productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();

        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        productsList = new ArrayList<>();
        productsList.add(product);
    }

    @AfterEach
    void tearDown() {
    }

    //There will be a total of 4 tests as there is a total of 4 different cases:
    @Test
    void prepareSuccessfulViewTest1() throws IOException, SQLException {
        /** This is the test where all three modifications are successful. Thus, all the changed values should be updated
         * to possess their new properties */

        changedDescription = "This dress was bought in 1984.";
        changedPrice = "12";
        float changedPriceFloat = Float.parseFloat(changedPrice);

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
                //First test if the required changes have been made and correctly outputted
                System.out.println(changeProductOutputData.getProduct().getDescription());
                assertEquals(changedDescription, changeProductOutputData.getProduct().getDescription());
                assertEquals(changedPriceFloat, changeProductOutputData.getProduct().getPrice());
                assertEquals("Successfully modified product", changeProductOutputData.getMessage());

                //TODO figure out if the ones above is necessary??? It seems redundant
                //Goes into the database to see if the product has actually been changed in the database
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(dataBaseProduct.getPrice(), changeProductOutputData.getProduct().getPrice());
                //TODO fix this user part if we need to pull it from the data base using in Memory
                assertEquals(changeProductOutputData.getUser(), user);
                //Together these are testing if the interactor has performed its functionalities, that is both change the product in the database and pass the correct updated product to the Presenter.
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface);


        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }

    @Test
    void prepareSuccessfulViewTest2() throws IOException, SQLException {
        /** This is the test where only the description works and the new price they entered is invalid. */

        changedDescription = "This dress was bought in 1984.";
        changedPrice = "-3";

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
                //First test if the required changes have been made and correctly outputted
                assertEquals(changedDescription, changeProductOutputData.getProduct().getDescription());
                assertEquals(product.getPrice(), changeProductOutputData.getProduct().getPrice());
                //The price should remain the same
                assertEquals("Only the price failed to update", changeProductOutputData.getMessage());
                //Goes into the database to see if the product has actually been changed in the database
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(dataBaseProduct.getPrice(), changeProductOutputData.getProduct().getPrice());

                //Together these are testing if the interactor has performed its functionalities, that is both change the product in the database and pass the correct updated product to the Presenter.
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);
        ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface = new InMemoryProductUpdatePictureDataAccessObject(productsList);
        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface = new InMemoryProductUpdatePriceDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface);

        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }

    @Test
    void prepareSuccessfulViewTest3() throws IOException, SQLException {
        /** This is the test where only the price works and the new description they entered is invalid. */

        changedDescription = "";
        changedPrice = "12";
        float changedPriceFloat = Float.parseFloat(changedPrice);

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
                //First test if the required changes have been made and correctly outputted
                assertEquals(product.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(changedPriceFloat, changeProductOutputData.getProduct().getPrice());
                //The price should remain the same
                assertEquals("Only the description failed to update", changeProductOutputData.getMessage());
                //Goes into the database to see if the product has actually been changed in the database
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(dataBaseProduct.getPrice(), changeProductOutputData.getProduct().getPrice());

                //Together these are testing if the interactor has performed its functionalities, that is both change the product in the database and pass the correct updated product to the Presenter.
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface);

        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }

    @Test
    void prepareSuccessfulViewTest4() throws IOException, SQLException {
        /** This is the test where both the description and price fails to update. */

        changedDescription = "";
        changedPrice = "-3";
        float changedPriceFloat = Float.parseFloat(changedPrice);

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
                //First test if the required changes have been made and correctly outputted
                assertEquals(product.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(product.getPrice(), changeProductOutputData.getProduct().getPrice());
                //The price should remain the same
                assertEquals("Both the description and price failed to update", changeProductOutputData.getMessage());
                //Goes into the database to see if the product has actually been changed in the database
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(dataBaseProduct.getPrice(), changeProductOutputData.getProduct().getPrice());

                //Together these are testing if the interactor has performed its functionalities, that is both change the product in the database and pass the correct updated product to the Presenter.
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface);

        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }
}