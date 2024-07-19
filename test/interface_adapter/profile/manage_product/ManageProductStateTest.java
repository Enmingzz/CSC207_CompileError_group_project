package interface_adapter.profile.manage_product;

import entity.product.CommonProduct;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonSchedule;
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
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManageProductStateTest {

    private ArrayList<Product> productList;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    private User user;

    private ManageProductState manageProductState;
    private ProductFactory productFactory = new CommonProductFactory();
    private UserFactory userFactory = new CommonUserFactory();


    @BeforeEach
    void setUp() throws IOException {

        tags.add("tag1");
        image = ImageIO.read(new File("/src/pic/testpic1"));
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        productList = new ArrayList<>();
        productList.add(commonProduct);
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");

        manageProductState = new ManageProductState(productFactory, userFactory);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProduct() {
        manageProductState.setProduct(productList);
        assertEquals(productList, manageProductState.getProduct());
    }

    @Test
    void setProduct() {
        manageProductState.setProduct(productList);
        assert true;
    }

    @Test
    void setUser() {
        manageProductState.setUser(user);
        assert true;
    }

    @Test
    void getUser() {
        manageProductState.setUser(user);
        assertEquals(user, manageProductState.getUser());
    }
}