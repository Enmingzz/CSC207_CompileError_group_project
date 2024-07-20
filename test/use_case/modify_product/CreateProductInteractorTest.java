package use_case.modify_product;

import data_access.in_memory.product.InMemoryProductCreateDataAccessObject;
import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.interfaces.product.ProductCreateDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.product.CommonProductFactory;
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

import static org.junit.jupiter.api.Assertions.*;

class CreateProductInteractorTest {
    private User user;
    private Image image;
    private String description;
    private String price;
    private String title;
    private String eTransferEmail;
    private String address;
    private ArrayList<String> listTags;
    private float priceFloat;
    private ProductFactory productFactory;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void prepareSuccessfulViewTest1() throws IOException, SQLException {
        /** This is a test where the creation of the product is successful */
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject();

        image = ImageIO.read(new File("src/pic/testpic1.png"));
        description = "It was worn once";
        price = "9";
        priceFloat = Float.parseFloat(price);
        title = "Red Dress";
        eTransferEmail = "calico.cat@mail.utoronto.ca";
        address = "123College";
        listTags = new ArrayList<>();
        listTags.add("clothes");

        CreateProductOutputBoundary createProductOutputBoundary = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) throws SQLException, IOException {
                //First ensure that all the input data are correctly implemented to create the product
                assertEquals(priceFloat, createProductOutputData.getProduct().getPrice());
                assertEquals(image, createProductOutputData.getProduct().getImage());
                assertEquals(description, createProductOutputData.getProduct().getDescription());
                assertEquals(title, createProductOutputData.getProduct().getTitle());
                assertEquals(eTransferEmail, createProductOutputData.getProduct().geteTransferEmail());
                assertEquals(address, createProductOutputData.getProduct().getAddress());
                assertEquals(listTags, createProductOutputData.getProduct().getListTags());
                assertEquals(user, createProductOutputData.getUser());

                //ensures that it is saved into the database
                assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(createProductOutputData.getProduct().getProductID()),
                        createProductOutputData.getProduct());
            }
            @Override
            public void prepareFailedView(String error) {
                assert(false);
            }
        };

        productFactory = new CommonProductFactory();
        ProductCreateDataAccessInterface inMemoryProductCreateDataAccessObject = new InMemoryProductCreateDataAccessObject();
        CreateProductInteractor createProductInteractor = new CreateProductInteractor(inMemoryProductCreateDataAccessObject,
                createProductOutputBoundary, productFactory);

        CreateProductInputData inputData = new CreateProductInputData(user, image, description, price, title, eTransferEmail, address, listTags);
        createProductInteractor.execute(inputData);
    }

    @Test
    void prepareSuccessfulViewTest2() throws IOException, SQLException {
        /** This is a test where the image fails to upload */

        image = null;
        description = "It was worn once";
        price = "9";
        priceFloat = Float.parseFloat(price);
        title = "Red Dress";
        eTransferEmail = "calico.cat@mail.utoronto.ca";
        address = "123College";
        listTags = new ArrayList<>();
        listTags.add("clothes");

        CreateProductOutputBoundary createProductOutputBoundary = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) throws SQLException, IOException {
                assert(false);
            }
            @Override
            public void prepareFailedView(String error) {
                assertEquals(error, "You must upload a valid image of the product.");
            }
        };

        ProductCreateDataAccessInterface inMemoryProductCreateDataAccessObject = new InMemoryProductCreateDataAccessObject();
        CreateProductInteractor createProductInteractor = new CreateProductInteractor(inMemoryProductCreateDataAccessObject,
                createProductOutputBoundary, productFactory);

        CreateProductInputData inputData = new CreateProductInputData(user, image, description, price, title, eTransferEmail, address, listTags);
        createProductInteractor.execute(inputData);
    }

    @Test
    void prepareSuccessfulViewTest3() throws IOException, SQLException {
        /** This is a test where the image fails to upload */

        image = null;
        description = "It was worn once";
        price = "9";
        priceFloat = Float.parseFloat(price);
        title = "Red Dress";
        eTransferEmail = "calico.cat@mail.utoronto.ca";
        address = "123College";
        listTags = new ArrayList<>();
        listTags.add("clothes");

        CreateProductOutputBoundary createProductOutputBoundary = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(CreateProductOutputData createProductOutputData) throws SQLException, IOException {
                assert(false);
            }
            @Override
            public void prepareFailedView(String error) {
                assertEquals(error, "You must upload a valid image of the product.");
            }
        };

        ProductCreateDataAccessInterface inMemoryProductCreateDataAccessObject = new InMemoryProductCreateDataAccessObject();
        CreateProductInteractor createProductInteractor = new CreateProductInteractor(inMemoryProductCreateDataAccessObject,
                createProductOutputBoundary, productFactory);

        CreateProductInputData inputData = new CreateProductInputData(user, image, description, price, title, eTransferEmail, address, listTags);
        createProductInteractor.execute(inputData);
    }
}