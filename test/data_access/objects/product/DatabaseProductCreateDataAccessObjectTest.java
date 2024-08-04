package data_access.objects.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.CommonProduct;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonSchedule;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
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

class DatabaseProductCreateDataAccessObjectTest {

    private ProductCreateDataAccessInterface databaseProductCreateDataAccessObject;
    private ProductReadByNameDataAccessInterface databaseProductReadByNameDataAccessObject;
    private Product commonProduct;
    private Schedule commonSchedule;
    private LocalDateTime startTime;
    private Image image;
    private ArrayList<String> tags = new ArrayList<>();
    private LocalDateTime time;
    private ArrayList<LocalDateTime> localDateTimeList;
    private String studentNumber = "123456";

    @BeforeEach
    void setUp() throws SQLException, IOException {
        tags.add("tag1");
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        time = LocalDateTime.now();
        localDateTimeList = new ArrayList<>();
        localDateTimeList.add(time);
        commonSchedule = new CommonSchedule(time, localDateTimeList);
        commonProduct = new CommonProduct(image, "test product", "pro", 10, 5, 0,
                "hanrui@mail", studentNumber, "hanrui123456", tags, "123456", commonSchedule);
        databaseProductCreateDataAccessObject = new DatabaseProductCreateDataAccessObject();
        ProductFactory commonProductFactory = new CommonProductFactory();
        ScheduleFactory commonScheduleFactory = new CommonScheduleFactory();
        databaseProductReadByNameDataAccessObject =
                new DatabaseProductReadByNameDataAccessObject(commonProductFactory,
                        commonScheduleFactory);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveProduct() throws SQLException, IOException {

        ArrayList<Product> products = databaseProductReadByNameDataAccessObject.getProductByName("pro");
        Product product = products.get(0);

        databaseProductCreateDataAccessObject.saveProduct(commonProduct);
        assertEquals(commonProduct.getDescription(), product.getDescription());
    }

}