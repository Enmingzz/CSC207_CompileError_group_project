package use_case.modify_product;

import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rate_product.GetRatePageOutputData;
import use_case.rate_product.RateProductOutputData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ViewCreateProductOutputDataTest {

    User user;
    ViewCreateProductOutputData viewCreateProductOutputData;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        viewCreateProductOutputData = new ViewCreateProductOutputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSeller() {assertEquals(user, viewCreateProductOutputData.getUser());}


}