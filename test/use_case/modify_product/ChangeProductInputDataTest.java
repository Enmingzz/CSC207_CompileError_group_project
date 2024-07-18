package use_case.modify_product;

import entity.product.CommonProduct;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
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

class ChangeProductInputDataTest {
    private ChangeProductInputData changeProductInputData;

    private User user;
    private String changedDescription ;
    private String changedPrice;
    private Product product;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        changedDescription = "This dress was bought in 1984.";
        changedPrice = "12.3";

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
        String productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();

        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        changeProductInputData = new ChangeProductInputData(user, product, changedDescription, changedPrice);
    }

    @Test
    void getUser() {
        assertEquals(user, changeProductInputData.getUser());
    }
    @Test
    void getProduct() {
        assertEquals(product, changeProductInputData.getProduct());
    }
    @Test
    void getChangeProductDescription() {
        assertEquals(changedDescription, changeProductInputData.getChangedDescription());
    }
    @Test
    void getChangedPrice() {
        assertEquals(changedPrice, changeProductInputData.getChangedPrice());
    }
    @AfterEach
    void tearDown() {
    }

}