package interface_adapter.login;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {
    private String studentNumber;
    private String studentNumberError = null;
    private String password;
    private String passwordError = null;
    private User commonUser;
    private boolean isChanged = false;

    private LoginState loginState;


    @BeforeEach
    void setUp() {
        LoginState copy = new LoginState();
        loginState = new LoginState(copy);
        studentNumber = "123456";
        password = "123456";
        commonUser = new CommonUser("hanrui", password, "hanrui@mail", 0, studentNumber);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudentNumber() {

    }

    @Test
    void getStudentNumberError() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getPasswordError() {
    }

}