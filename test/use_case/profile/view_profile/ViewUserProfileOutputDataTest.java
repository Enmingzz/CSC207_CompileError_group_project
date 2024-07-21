package use_case.profile.view_profile;

import data_access.in_memory.product.InMemoryProductReadByUserDataAccessObject;
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

class ViewUserProfileOutputDataTest {

    private ViewUserProfileOutputData viewUserProfileOutputData;
    private User buyer;
    private User seller;
    private ArrayList<Product> products;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;
    private Product commonProduct;

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
        products.add(commonProduct);
        buyer = new CommonUser("hanrui", "1234", "hanrui@mail", 1,"12122");
        seller = new CommonUser("enming", "12", "enming.zhang@mail", 2, "111");
        viewUserProfileOutputData = new ViewUserProfileOutputData(seller, buyer, products);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSeller() {
        assertEquals(seller, viewUserProfileOutputData.getSeller());
    }

    @Test
    void getBuyer() {
        assertEquals(buyer, viewUserProfileOutputData.getBuyer());
    }

    @Test
    void getProductList() {
        assertEquals(products, viewUserProfileOutputData.getProductList());
    }
}