package use_case.profile.manage_product;

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
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManageProductOutputDataTest {

    private ManageProductInputData manageProductInputData;
    private User user;

    ManageProductOutputData manageProductOutputData;
    private ArrayList<Product> productList;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags = new ArrayList<>();
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    @BeforeEach
    void setUp() throws IOException {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        manageProductInputData = new ManageProductInputData(user);

        tags.add("tag1");
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        productList = new ArrayList<>();
        productList.add(commonProduct);
        manageProductOutputData = new ManageProductOutputData(productList, user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProducts() {
        assertEquals(productList, manageProductOutputData.getProducts());
    }

}