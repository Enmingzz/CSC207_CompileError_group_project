package use_case.signup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupInputDataTest {

    private SignupInputData signupInputData;

    @BeforeEach
    void setUp() {
        signupInputData = new SignupInputData("hanrui", "123456", "123456", "hanrui@mail",
                "1234","1234",
                "11111");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsername() {
        assertEquals("hanrui", signupInputData.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("123456", signupInputData.getPassword());
    }

    @Test
    void getInputVerificationCode() {
        assertEquals("1234", signupInputData.getInputVerificationCode());
    }

    @Test
    void getGeneratedVerificationCode() {
        assertEquals("1234", signupInputData.getGeneratedVerificationCode());
    }

    @Test
    void getEmailAddress() {
        assertEquals("hanrui@mail", signupInputData.getEmailAddress());
    }

    @Test
    void getRepeatPassword() {
        assertEquals("123456", signupInputData.getRepeatPassword());
    }

    @Test
    void getStudentNumber() {
        assertEquals("11111", signupInputData.getStudentNumber());
    }

}