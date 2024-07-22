package use_case.modify_product;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateDescriptionDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateNameDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for ChangeProductTitle.
 */
class ChangeProductTitleTest {

    private Product product;
    private String changedTitle;
    private ArrayList<Product> productsList;
    private String productID;

    private ProductUpdateNameDataAccessInterface inMemoryProductUpdateNameDataAccessObject;
    private ChangeProductTitle changeProductTitle;

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

        inMemoryProductUpdateNameDataAccessObject = new InMemoryProductUpdateNameDataAccessObject(productsList);
        changeProductTitle = new ChangeProductTitle(inMemoryProductUpdateNameDataAccessObject);
    }

    /**
     * Cleans up the test environment after each test.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Tests the execute method of ChangedProductTitle to ensure it correctly updates the product name/title.
     *
     * @throws IOException if there is an error during execution.
     * @throws SQLException if there is an error with SQL execution.
     */
    @Test
    void executeTrueTest() throws IOException, SQLException {
        // The title is changed
        changedTitle = "This was once used by a dog.";

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);

        Product newProduct = changeProductTitle.execute(product, changedTitle);
        assertEquals(newProduct.getTitle(), changedTitle);

        assertEquals(product.getPrice(),
                newProduct.getPrice());
        assertEquals(product.getImage(),
                newProduct.getImage());
        assertEquals(product.getDescription(),
                newProduct.getDescription());

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
    void executeTrueTest2() throws IOException, SQLException {
        // The input title is the same
        changedTitle = "Red Dress";

        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        Product newProduct = changeProductTitle.execute(product, changedTitle);
        assertEquals(product.getTitle(), changedTitle);

        assertEquals(product.getPrice(),
                newProduct.getPrice());
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
