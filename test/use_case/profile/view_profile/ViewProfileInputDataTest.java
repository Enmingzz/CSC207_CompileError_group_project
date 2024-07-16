package use_case.profile.view_profile;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewProfileInputDataTest {
    private User user;
    private ViewProfileInputData viewProfileInputData;

    @BeforeEach
    void setUp() {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        viewProfileInputData = new ViewProfileInputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(user, viewProfileInputData.getUser());
    }
}