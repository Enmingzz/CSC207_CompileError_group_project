package use_case.modify_product;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdatePictureDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdatePriceDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChangeProductPriceInteractorTest {
    private String changedPrice;
    private Product product;
    private ArrayList<Product> productsList;
    private String productID;

    private ProductUpdatePriceDataAccessInterface inMemoryProductUpdatePriceDataAccessObject;
    private ChangeProductPrice changeProductPrice;
    void setUp() throws IOException {

        Image image = ImageIO.read(new File("D:/24 summer/csc207/CSC207_CompileError_group_project/src/pic/testpic1.png"));
        String description = "It was worn once";
        float price = 2;
        String title = "Red Dress";
        int state = 1;
        Integer rating = 3;
        String eTransferEmail = "calico.cat@mail.utoronto.ca";
        String sellerStudentNumber = "1010101010";
        String address = "123College";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("clothes");
        productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();
        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        productsList = new ArrayList<>();
        productsList.add(product);


        inMemoryProductUpdatePriceDataAccessObject = new InMemoryProductUpdatePriceDataAccessObject(productsList);
        changeProductPrice = new ChangeProductPrice(inMemoryProductUpdatePriceDataAccessObject);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeTrueTest() throws IOException, SQLException {
        changedPrice = "100";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        changeProductPrice.execute(product, changedPrice);
        float floatChangedPrice = Float.parseFloat(changedPrice);
        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getPrice(), floatChangedPrice);
    }

    @Test
    void executeFalseTest1() throws IOException, SQLException {
        //The case when the price provided is a negative number
        changedPrice = "-10";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        boolean result = changeProductPrice.execute(product, changedPrice);
        float floatChangedPrice = Float.parseFloat(changedPrice);
        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getPrice(), floatChangedPrice);
        assertTrue(result);
    }

    @Test
    void executeFalseTest2() throws SQLException, IOException {
        //The case where the price provided is not a float
        changedPrice = "asdsa";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        boolean result = changeProductPrice.execute(product, changedPrice);
        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getPrice(), product.getPrice());
        assertFalse(result);
    }

    @Test
    void executeFalseTest3() throws SQLException, IOException {
        //The case where the price provided has more than 2 decimal places
        float people = 2.345f;
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        boolean result = changeProductPrice.execute(product, changedPrice);
        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getPrice(), product.getPrice());
        assertFalse(result);
    }

}