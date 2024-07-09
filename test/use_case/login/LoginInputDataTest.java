package use_case.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInputDataTest {

    private String studentNumber;
    private String password;
    private LoginInputData loginInputData;

    @BeforeEach
    void setUp() {
        studentNumber = "123456";
        password = "123456";
        loginInputData = new LoginInputData(studentNumber, password);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudentNumber() {
        assertEquals(studentNumber, loginInputData.getStudentNumber());
    }

    @Test
    void getPassword() {
        assertEquals(password, loginInputData.getPassword());
    }

}