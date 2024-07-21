package use_case.profile.view_profile;

import data_access.in_memory.product.InMemoryProductReadByUserDataAccessObject;
import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.profile.view_profile.ViewUserProfilePresenter;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
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

class ViewUserProfileInteractorTest {

    private ViewUserProfileInputBoundary interactor;
    private ViewUserProfileInputData inputData;
    private ViewUserProfileOutputData outputData;
    private User buyer;
    private String studentNumber;
    private ArrayList<Product> products;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;
    private Product commonProduct;
    private ProductReadByUserDataAccessInterface productReadByUserDataAccessObject;
    private UserReadDataAccessInterface userReadDataAccessObject;

    @BeforeEach
    void setUp() throws IOException, SQLException {
        products = new ArrayList<>();
        tags = new ArrayList<>();
        tags.add("tag1");
        image = null;
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        studentNumber = "123456";
        products.add(commonProduct);
        productReadByUserDataAccessObject = new InMemoryProductReadByUserDataAccessObject(products);
        User commonUser = new CommonUser("enming", "123", "enming.zhang@mail", 0, "123456");
        UserFactory userFactory = new CommonUserFactory();
        ArrayList<User> users = new ArrayList<>();
        users.add(commonUser);
        userReadDataAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        buyer = new CommonUser("hanrui", "1234", "hanrui@mail", 1,"12122");
        inputData = new ViewUserProfileInputData(studentNumber, buyer);
        ViewUserProfileOutputBoundary viewUserProfilePresenter = new ViewUserProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData) {
                assertEquals(studentNumber, viewUserProfileOutputData.getSeller().getStudentNumber());
                assertEquals(buyer, viewUserProfileOutputData.getBuyer());
                assertEquals(products.get(0).getDescription(),
                        viewUserProfileOutputData.getProductList().get(0).getDescription());
                assertEquals(products.get(0).getProductID(),
                        viewUserProfileOutputData.getProductList().get(0).getProductID());
                assertEquals(products.get(0).getPrice(),
                        viewUserProfileOutputData.getProductList().get(0).getPrice());
                assertEquals(products.get(0).getImage(),
                        viewUserProfileOutputData.getProductList().get(0).getImage());
                assertEquals(products.get(0).geteTransferEmail(),
                        viewUserProfileOutputData.getProductList().get(0).geteTransferEmail());
                assertEquals(products.get(0).getSellerStudentNumber(),
                        viewUserProfileOutputData.getProductList().get(0).getSellerStudentNumber());
            }
        };

        interactor = new ViewUserProfileInteractor(viewUserProfilePresenter,
                userReadDataAccessObject, productReadByUserDataAccessObject);
        interactor.execute(inputData);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
    }
}