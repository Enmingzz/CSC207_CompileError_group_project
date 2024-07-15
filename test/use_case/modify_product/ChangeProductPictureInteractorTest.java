package use_case.modify_product;

import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdatePictureDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//TODO consider when SQLException or IOExceptions are thrown

class ChangeProductPictureInteractorTest {
    private Image changedPicture;
    private Product product;
    private ArrayList<Product> productsList;
    private String productID;

    private ProductUpdatePictureDataAccessInterface inMemoryProductUpdatePictureDataAccessObject;
    private ChangeProductPicture changeProductPicture;


    @BeforeEach
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


        inMemoryProductUpdatePictureDataAccessObject = new InMemoryProductUpdatePictureDataAccessObject(productsList);
        changeProductPicture = new ChangeProductPicture(inMemoryProductUpdatePictureDataAccessObject);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeTest() throws IOException, SQLException {
        changedPicture = ImageIO.read(new File("src/pic/testpic1.png"));
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(productsList);
        changeProductPicture.execute(product, changedPicture);

        assertEquals(inMemoryProductReadByIdDataAccessObject.getProductById(product.getProductID()).getImage(), changedPicture);
    }

    @Test
    void executeThrowsSQLExceptionTest() throws SQLException, IOException{
        //Test to see if the proper exception is thrown when the changedPicture is not a valid
        changedPicture = "" ;

        doThrow(SQLException.class).when(inMemoryProductUpdatePictureDataAccessObject).updateProductPicture(product, changedPicture);
        assertThrows(SQLException.class, () -> changeProductPicture.execute(product, changedPicture));

    }


}