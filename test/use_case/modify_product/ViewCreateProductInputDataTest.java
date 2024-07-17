package use_case.modify_product;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.View;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ViewCreateProductInputDataTest {
    private ViewCreateProductInputData viewCreateProductInputData;
    private User user;

    @BeforeEach
    void setUp() throws IOException {
        user = new CommonUser("Calico", "Cat123", "calico.cat@mail.utoronto.ca", 4, "1010101010");
        viewCreateProductInputData = new ViewCreateProductInputData(user);
    }
    @AfterEach
    void tearDown() {
        user = null;
    }
    @Test
    void getUser() {
        assertEquals(user, viewCreateProductInputData.getUser());
    }

}