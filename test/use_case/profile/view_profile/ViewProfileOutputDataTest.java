package use_case.profile.view_profile;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ViewProfileOutputDataTest {
    private User user;
    private ViewProfileOutputData viewProfileOutputData;

    @BeforeEach
    void setUp() {
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getUser() {
        viewProfileOutputData = new ViewProfileOutputData(user);
        assertEquals(user, viewProfileOutputData.getUser());
    }
}