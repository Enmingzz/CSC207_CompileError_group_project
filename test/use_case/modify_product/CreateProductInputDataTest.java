package use_case.modify_product;

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

class CreateProductInputDataTest {
    private CreateProductInputData createProductInputData;

    private User user;
    private Image image;
    private String description;
    private String price;
    private String title;
    private String eTransferEmail;
    private String address;
    private ArrayList<String> listTags;

    @BeforeEach
    void setUp() throws IOException {
        user = new CommonUser("Calico", "Cat123", "calico.cat@mail.utoronto.ca", 4, "1010101010");
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        description = "It was worn once";
        price = "2";
        title = "Red Dress";
        eTransferEmail = "calico.cat@mail.utoronto.ca";
        address = "123College";
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("clothes");

        createProductInputData = new CreateProductInputData(user, image, description, price, title, eTransferEmail, address, listTags);
    }
    @AfterEach
    void tearDown() {
        user = null;
        image = null;
        description = null;
        price = null;
        title = null;
        eTransferEmail = null;
        address = null;
        createProductInputData = null;
    }
    @Test
    void getUser() {
        assertEquals(user, createProductInputData.getUser());;
    }

    void getImage() {
        assertEquals(image, createProductInputData.getImage());;
    }

    void getPrice() {
        assertEquals(price, createProductInputData.getPrice());;
    }

    void getTitle() {
        assertEquals(title, createProductInputData.getTitle());;
    }

    void geteTransferEmail() {
        assertEquals(eTransferEmail, createProductInputData.geteTransferEmail());;
    }

    void getAddress() {
        assertEquals(address, createProductInputData.getAddress());;
    }

    void getListTags() {
        assertEquals(listTags, createProductInputData.getListTags());;
    }

}