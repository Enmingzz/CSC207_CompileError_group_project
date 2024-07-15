package use_case.modify_product;
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

class ViewModifyProductInputDataTest {
    private ViewModifyProductInputData viewModifyProductInputData;
    private User user;
    private Product product;

    @BeforeEach
    void setUp() throws IOException {
        user = new CommonUser("Calico", "Cat123", "calico.cat@mail.utoronto.ca", 4, "1010101010");

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

        product = new CommonProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        viewModifyProductInputData = new ViewModifyProductInputData(user, product);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(user, viewModifyProductInputData.getUser());;
    }
    @Test
    void getProduct() {
        assertEquals(product, viewModifyProductInputData.getProduct());;
    }
}