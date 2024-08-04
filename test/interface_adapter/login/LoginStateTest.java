package interface_adapter.login;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {
    private String studentNumber;
    private String studentNumberError;
    private String password;
    private String passwordError;
    private boolean isChanged = false;

    private LoginState loginState;


    @BeforeEach
    void setUp() {
        LoginState copy = new LoginState();
        loginState = new LoginState(copy);
        studentNumber = "123456";
        password = "123456";
        studentNumberError = "error1";
        passwordError = "error2";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudentNumber() {
        loginState.setStudentNumber(studentNumber);
        assertEquals(studentNumber, loginState.getStudentNumber());
    }

    @Test
    void getStudentNumberError() {
        loginState.setStudentNumberError(studentNumberError);
        assertEquals(studentNumberError, loginState.getStudentNumberError());
    }

    @Test
    void getPassword() {
        loginState.setPassword(password);
        assertEquals(password, loginState.getPassword());
    }

    @Test
    void getPasswordError() {
        loginState.setPasswordError(passwordError);
        assertEquals(passwordError, loginState.getPasswordError());
    }

}