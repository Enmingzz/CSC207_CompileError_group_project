package use_case.profile.manage_product;

import data_access.in_memory.product.InMemoryProductReadByUserDataAccessObject;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.User;
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

class ManageProductInteractorTest {

    private ManageProductInputBoundary manageProductInteractor;
    private ManageProductInputData manageProductInputData;
    private ProductReadByUserDataAccessInterface inMemoryProductReadByUserDataAccessObject;
    private ManageProductOutputBoundary manageProductOutputBoundary;

    private ArrayList<Product> productList;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    @BeforeEach
    void setUp() throws IOException {
        User user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        manageProductInputData = new ManageProductInputData(user);
        productList = new ArrayList<Product>();
        tags = new ArrayList<String>();
        tags.add("tag1");

        inMemoryProductReadByUserDataAccessObject = new InMemoryProductReadByUserDataAccessObject();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successTestEmptyDataBase() throws SQLException, IOException {

        manageProductOutputBoundary = new ManageProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ManageProductOutputData manageProductOutputData) {
                assertEquals(manageProductOutputData.getProducts().size(), 0);
            }
        };
        manageProductInteractor = new ManageProductInteractor(manageProductOutputBoundary, inMemoryProductReadByUserDataAccessObject);
        manageProductInteractor.execute(manageProductInputData);
    }

    @Test
    void successTestProductsDifferentSellerID() throws SQLException, IOException {
        for (int i = 0; i < 3; i++){
            image = ImageIO.read(new File("src/pic/testpic1.png"));
            time = LocalDateTime.now();
            localDateTimeList = new ArrayList<>();
            localDateTimeList.add(time);
            commonSchedule = new CommonSchedule(time, localDateTimeList);
            commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                    "hanrui@mail", "123456", "hanrui123456",
                    tags, String.valueOf(i), commonSchedule);

            productList.add(commonProduct);
        }
        Product last = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "1", "hanrui123456",
                tags, "4", commonSchedule);
        productList.add(last);

        inMemoryProductReadByUserDataAccessObject = new InMemoryProductReadByUserDataAccessObject(productList);

        manageProductOutputBoundary = new ManageProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ManageProductOutputData manageProductOutputData) {
                assertEquals(manageProductOutputData.getProducts().size(), 3);
                assert !manageProductOutputData.getProducts().contains(last);
            }
        };
        manageProductInteractor = new ManageProductInteractor(manageProductOutputBoundary, inMemoryProductReadByUserDataAccessObject);
        manageProductInteractor.execute(manageProductInputData);
    }

    @Test
    void successTestNoProducts() throws SQLException, IOException {
        for (int i = 0; i < 3; i++){
            image = ImageIO.read(new File("src/pic/testpic1.png"));
            time = LocalDateTime.now();
            localDateTimeList = new ArrayList<>();
            localDateTimeList.add(time);
            commonSchedule = new CommonSchedule(time, localDateTimeList);
            commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                    "hanrui@mail", "1", "hanrui123456",
                    tags, String.valueOf(i), commonSchedule);

            productList.add(commonProduct);
        }

        inMemoryProductReadByUserDataAccessObject = new InMemoryProductReadByUserDataAccessObject(productList);

        manageProductOutputBoundary = new ManageProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ManageProductOutputData manageProductOutputData) {
                assertEquals(manageProductOutputData.getProducts().size(), 0);
            }
        };
        manageProductInteractor = new ManageProductInteractor(manageProductOutputBoundary, inMemoryProductReadByUserDataAccessObject);
        manageProductInteractor.execute(manageProductInputData);
    }
}