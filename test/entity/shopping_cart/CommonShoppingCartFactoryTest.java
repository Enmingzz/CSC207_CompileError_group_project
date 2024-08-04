package entity.shopping_cart;

import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;
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
class CommonShoppingCartFactoryTest {

    private ShoppingCart commonShoppingCart;
    private ShoppingCartFactory commonShoppingCartFactory;
    private ArrayList<Product> productList;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags = new ArrayList<>();
    private float price = 10;
    private String studentNumber = "123456";
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

    @BeforeEach
    void setUp() throws IOException {
        tags.add("tag1");
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        productList = new ArrayList<>();
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        productList.add(commonProduct);
        commonShoppingCart = new CommonShoppingCart(price,studentNumber, productList);
        commonShoppingCartFactory = new CommonShoppingCartFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createShoppingCart() {
        ShoppingCart newCommonShoppingCart =  commonShoppingCartFactory.createShoppingCart(price,
                studentNumber, productList);
        assertEquals(commonShoppingCart.getStudentNumber(), newCommonShoppingCart.getStudentNumber());
    }
}