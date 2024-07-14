package use_case.schedule;

import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
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

class BuyerSelectScheduleInputDataTest {
    private User buyer;
    private Product product;
    private LocalDateTime selectedTime;
    private BuyerSelectScheduleInputData buyerSelectScheduleInputData;

    @BeforeEach
    void setUp() throws IOException {
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 2;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        sellerTime.add(LocalDateTime.parse("2024-07-13T12:00:00"));
        sellerTime.add(LocalDateTime.parse("2024-07-13T13:00:00"));
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);


        buyer = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca", 5, "1234567890");

        selectedTime = LocalDateTime.parse("2024-07-13T12:00:00");

        buyerSelectScheduleInputData = new BuyerSelectScheduleInputData(buyer, product,selectedTime);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBuyer() {assertEquals(buyer, buyerSelectScheduleInputData.getBuyer());
    }

    @Test
    void getProduct() {assertEquals(product, buyerSelectScheduleInputData.getProduct());
    }

    @Test
    void getSelectedTime() {assertEquals(selectedTime, buyerSelectScheduleInputData.getSelectedTime());
    }
}