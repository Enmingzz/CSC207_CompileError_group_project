package use_case.rate_product;

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

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRatePageInputDataTest {
    private GetRatePageInputData getRatePageInputData;

    private Product product;
    private User user;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Samoyed";
        String password = "dog123";
        String email = "samoyed.dog@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "12345678";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

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
        String productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();

        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        getRatePageInputData = new GetRatePageInputData(user, product);

    }

    @Test
    void getUser() {
        assertEquals(user, getRatePageInputData.getUser());
    }

    @Test
    void getProduct() {
        assertEquals(product, getRatePageInputData.getProduct());
    }

}
