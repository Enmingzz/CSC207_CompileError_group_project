package use_case.login;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginOutputDataTest {

    private LoginOutputData loginOutputData;
    User commonUser;

    @BeforeEach
    void setUp() {
        commonUser = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        loginOutputData = new LoginOutputData(commonUser);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(commonUser, loginOutputData.getUser());
    }

}