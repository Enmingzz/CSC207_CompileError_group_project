package use_case.signup;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SignupOutputDataTest {

    private SignupOutputData signupOutputData;
    private User user;

    @BeforeEach
    void setUp() {
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        signupOutputData = new SignupOutputData(user, "no error");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(user, signupOutputData.getUser());
    }

    @Test
    void getError() {
        assertEquals("no error", signupOutputData.getError());
    }

}