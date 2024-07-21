package use_case.profile.view_profile;

import data_access.in_memory.product.InMemoryProductReadByUserDataAccessObject;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.profile.view_profile.ViewUserProfilePresenter;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
    private InMemoryProductReadByUserDataAccessObject productReadByUserDataAccessObject;

    @BeforeEach
    void setUp() throws IOException {
        products = new ArrayList<>();
        tags.add("tag1");
        image = ImageIO.read(new File("/src/pic/testpic1"));
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        studentNumber = "12345";
        products.add(commonProduct);
        productReadByUserDataAccessObject = new InMemoryProductReadByUserDataAccessObject(products);
        buyer = new CommonUser("hanrui", "1234", "hanrui@mail", 1,"12122");
        inputData = new ViewUserProfileInputData(studentNumber, buyer);
        ViewUserProfileOutputBoundary viewUserProfilePresenter = new ViewUserProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewUserProfileOutputData viewUserProfileOutputData) {
                assertEquals(studentNumber, viewUserProfileOutputData.getSeller().getStudentNumber());
                assertEquals(buyer, viewUserProfileOutputData.getBuyer());
                assertEquals(products, viewUserProfileOutputData.getProductList());
            }
        };

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
    }
}