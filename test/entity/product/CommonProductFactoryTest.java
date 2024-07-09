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
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonProductFactoryTest {

    private CommonProductFactory commonProductFactory;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags;
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;


    @BeforeEach
    void setUp() throws IOException {
        commonProductFactory = new CommonProductFactory();
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
    void createProduct() {
        Product newCommonProduct = commonProductFactory.createProduct(image, "test " +
                        "product", "pro",
                10, 5
            , 0,
                "hanrui@mail", "123456", "hanrui123456", tags, "123456", commonSchedule);
        assertEquals(commonProduct, newCommonProduct);
    }

}