package use_case.view_product;

import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUser;
import entity.user.User;
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

class ViewProductInputDataTest {
    private ViewProductInputData viewProductInputData;
    private Product product;
    private User user;

    @BeforeEach
    void setUp() throws IOException {
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = " ";
        float price = 1;
        String title = "ginger_cat";
        int state = 1;
        int rating = 5;
        String eTransferEmail = "";
        String sellerStudentNumber = "";
        String address = "";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        String productID = "";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        user = new CommonUser("ginger cat", "111", "ginger@mail.utoronto.ca",
                5, "1234567890");

        viewProductInputData = new ViewProductInputData(product, user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProduct() {assertEquals(product, viewProductInputData.getProduct());}

    @Test
    void getUser() {assertEquals(user, viewProductInputData.getUser());}
}