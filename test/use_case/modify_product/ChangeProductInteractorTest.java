package use_case.modify_product;

import static org.junit.jupiter.api.Assertions.*;

import data_access.in_memory.product.*;
import data_access.interfaces.product.*;
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
    private String changedDescription;
    private String changedPrice;
    private String changedAddress;
    private String changedTitle;
    private String changedEmail;
    private Image changedImage;
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
    void prepareSuccessfulViewTest() throws IOException, SQLException {
        /** This is the test where all five modifications are successful. Thus, all the changed values should be updated
         * to possess their new properties */

        changedDescription = "This dress was bought in 1984.";
        changedPrice = "12";
        float changedPriceFloat = Float.parseFloat(changedPrice);

        changedAddress = "321Bay";
        changedTitle = "Blue Dress";
        changedEmail = "333@email.com";
        changedImage = ImageIO.read(new File("src/pic/testpic3.png"));

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
                //First test if the required changes have been made and correctly outputted
                assertEquals(changedDescription, changeProductOutputData.getProduct().getDescription());
                assertEquals(changedPriceFloat, changeProductOutputData.getProduct().getPrice());
                assertEquals(changedAddress, changeProductOutputData.getProduct().getAddress());
                assertEquals(changedEmail, changeProductOutputData.getProduct().geteTransferEmail());
                assertEquals(changedImage, changeProductOutputData.getProduct().getImage());

                assertEquals("Successfully modified product", changeProductOutputData.getMessage());

                //Goes into the database to see if the product has actually been changed in the database
                Product dataBaseProduct = inMemoryProductReadByIdDataAccessObject.getProductById(productID);
                assertEquals(dataBaseProduct.getDescription(), changeProductOutputData.getProduct().getDescription());
                assertEquals(dataBaseProduct.getPrice(), changeProductOutputData.getProduct().getPrice());
                assertEquals(dataBaseProduct.getAddress(), changeProductOutputData.getProduct().getAddress());
                assertEquals(dataBaseProduct.geteTransferEmail(), changeProductOutputData.getProduct().geteTransferEmail());
                assertEquals(dataBaseProduct.getImage(), changeProductOutputData.getProduct().getImage());
                //TODO fix this user part if we need to pull it from the data base using in Memory
                assertEquals(changeProductOutputData.getUser(), user);
                //Together these are testing if the interactor has performed its functionalities
            }

            @Override
            public void prepareFailView(ChangeProductOutputData changeProductOutputData) {
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);
        ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface = new InMemoryProductUpdateAddressDataAccessObject(productsList);
        ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface = new InMemoryProductUpdateNameDataAccessObject(productsList);
        ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface = new InMemoryProductUpdatePictureDataAccessObject(productsList);
        ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface = new InMemoryProductUpdateTransferEmailDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface, productUpdateAddressDataAccessInterface, productUpdateNameDataAccessInterface,
                productUpdatePictureDataAccessInterface, productUpdateTransferEmailDataAccessInterface);


        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice, changedAddress, changedTitle, changedEmail, changedImage);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }

    @Test
    void prepareFailViewTest() throws IOException, SQLException {
        /** This is the test where it fails to update because all the input fields are empty.*/

        changedDescription = "";
        changedPrice = "";
        changedAddress = "";
        changedTitle = "";
        changedEmail = "";
        changedImage = null;

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        ChangeProductOutputBoundary changeProductPresenter = new ChangeProductOutputBoundary() {
            //This prepareSuccessfulView test is to ensure that
            @Override
            public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException {
            }

            @Override
            public void prepareFailView(ChangeProductOutputData changeProductOutputData) {
                assertEquals("You didn't Change any thing!", changeProductOutputData.getMessage());
            }
        };
        //mock database

        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface = new InMemoryProductUpdateDescriptionDataAccessObject(productsList);
        ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface = new InMemoryProductUpdateAddressDataAccessObject(productsList);
        ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface = new InMemoryProductUpdateNameDataAccessObject(productsList);
        ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface = new InMemoryProductUpdatePictureDataAccessObject(productsList);
        ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface = new InMemoryProductUpdateTransferEmailDataAccessObject(productsList);

        ChangeProductInteractor changeProductInteractor = new ChangeProductInteractor(changeProductPresenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessInterface, productUpdateAddressDataAccessInterface, productUpdateNameDataAccessInterface,
                productUpdatePictureDataAccessInterface, productUpdateTransferEmailDataAccessInterface);


        ChangeProductInputData inputData = new ChangeProductInputData(user, product, changedDescription, changedPrice, changedAddress, changedTitle, changedEmail, changedImage);
        changeProductInteractor.execute(inputData); //This sends Output Data to the successPresenter
    }
}