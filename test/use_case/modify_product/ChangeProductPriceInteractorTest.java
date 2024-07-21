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

/**
 * Unit test for ChangeProductPrice.
 */
class ChangeProductPriceInteractorTest {

    private String changedPrice;
    private Product product;
    private ArrayList<Product> productsList;
    private String productID;

    private ProductUpdatePriceDataAccessInterface inMemoryProductUpdatePriceDataAccessObject;
    private ChangeProductPrice changeProductPrice;

    /**
     * Sets up the test environment before each test.
     *
     * @throws IOException if there is an error reading the image file.
     */
    @BeforeEach
    void setUp() throws IOException {
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
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

    /**
     * Cleans up the test environment after each test.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Tests the execute method of ChangeProductPrice to ensure it correctly updates the product price.
     * This will check if the product's price is actually being updated in the database and will also check if
     * the returned product's price is correct
     *
     * @throws IOException  if there is an error during execution.
     * @throws SQLException if there is an error with SQL execution.
     */
    @Test
    void executeTrueTest() throws IOException, SQLException {
        changedPrice = "100";
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        Product newProduct = changeProductPrice.execute(product, changedPrice);
        float floatChangedPrice = Float.parseFloat(changedPrice);
        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getPrice(), floatChangedPrice);
        assertEquals(newProduct.getPrice(), floatChangedPrice);

        assertEquals(product.getImage(),
                newProduct.getImage());
        assertEquals(product.getDescription(),
                newProduct.getDescription());
        assertEquals(product.getTitle(),
                newProduct.getTitle());

        assertEquals(product.getAddress(),
                newProduct.getAddress());
        assertEquals(product.getSchedule().getBuyerTime(),
                newProduct.getSchedule().getBuyerTime());
        assertEquals(product.getSchedule().getSellerTime(),
                newProduct.getSchedule().getSellerTime());
        assertEquals(product.getState(),
                newProduct.getState());

        assertEquals(product.getSellerStudentNumber(),
                newProduct.getSellerStudentNumber());
        assertEquals(product.geteTransferEmail(),
                newProduct.geteTransferEmail());
        assertEquals(product.getListTags(),
                newProduct.getListTags());
    }

    @Test
    void executeTrueInvalidPrice1() throws IOException, SQLException {
        //The price entered is not a positive float
        changedPrice = "-99";
        Product newProduct = changeProductPrice.execute(product, changedPrice);
        assertEquals(newProduct.getPrice(), product.getPrice());

        assertEquals(product.getImage(),
                newProduct.getImage());
        assertEquals(product.getDescription(),
                newProduct.getDescription());
        assertEquals(product.getTitle(),
                newProduct.getTitle());

        assertEquals(product.getAddress(),
                newProduct.getAddress());
        assertEquals(product.getSchedule().getBuyerTime(),
                newProduct.getSchedule().getBuyerTime());
        assertEquals(product.getSchedule().getSellerTime(),
                newProduct.getSchedule().getSellerTime());
        assertEquals(product.getState(),
                newProduct.getState());

        assertEquals(product.getSellerStudentNumber(),
                newProduct.getSellerStudentNumber());
        assertEquals(product.geteTransferEmail(),
                newProduct.geteTransferEmail());
        assertEquals(product.getListTags(),
                newProduct.getListTags());
    }


    @Test
    void executeTrueInvalidPrice2() throws IOException, SQLException {
        //The price entered is not a float
        changedPrice = "-1sdf";
        Product newProduct = changeProductPrice.execute(product, changedPrice);
        assertEquals(newProduct.getPrice(), product.getPrice());

        assertEquals(product.getImage(),
                newProduct.getImage());
        assertEquals(product.getDescription(),
                newProduct.getDescription());
        assertEquals(product.getTitle(),
                newProduct.getTitle());

        assertEquals(product.getAddress(),
                newProduct.getAddress());
        assertEquals(product.getSchedule().getBuyerTime(),
                newProduct.getSchedule().getBuyerTime());
        assertEquals(product.getSchedule().getSellerTime(),
                newProduct.getSchedule().getSellerTime());
        assertEquals(product.getState(),
                newProduct.getState());

        assertEquals(product.getSellerStudentNumber(),
                newProduct.getSellerStudentNumber());
        assertEquals(product.geteTransferEmail(),
                newProduct.geteTransferEmail());
        assertEquals(product.getListTags(),
                newProduct.getListTags());
    }



}