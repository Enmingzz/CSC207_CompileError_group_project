package use_case.profile.manage_product;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManageProductInputDataTest {

    private ManageProductInputData manageProductInputData;
    private User user;

    @BeforeEach
    void setUp() {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        manageProductInputData = new ManageProductInputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(user, manageProductInputData.getUser());
    }

}