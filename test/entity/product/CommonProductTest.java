package entity.product;

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

class CommonProductTest {

    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;

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
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getImage() {
        assertEquals(image, commonProduct.getImage());
    }

    @Test
    void getDescription() {
        assertEquals("test product", commonProduct.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(10, commonProduct.getPrice());
    }

    @Test
    void getTitle() {
        assertEquals("pro", commonProduct.getTitle());
    }

    @Test
    void getRating() {
        assertEquals(5, commonProduct.getRating());
    }

    @Test
    void getState() {
        assertEquals("hanrui@mail", commonProduct.getState());
    }

    @Test
    void geteTransferEmail() {
        assertEquals("hanrui@mail", commonProduct.geteTransferEmail());
    }

    @Test
    void getSellerStudentNumber() {
        assertEquals("123456", commonProduct.getSellerStudentNumber());
    }

    @Test
    void getAddress() {
        assertEquals("hanrui@mail", commonProduct.getAddress());
    }

    @Test
    void getListTags() {
        assertEquals("hanrui@mail", commonProduct.getListTags());
    }

    @Test
    void getProductID() {
        assertEquals("123456", commonProduct.getProductID());
    }

    @Test
    void getSchedule() {
        Schedule schedule = commonProduct.getSchedule();
    }

}