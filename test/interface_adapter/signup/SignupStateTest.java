package interface_adapter.signup;

import interface_adapter.signup.signup.SignupState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupStateTest {

    private SignupState signupState;

    @BeforeEach
    void setUp() {
        signupState = new SignupState();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsername() {
        assertEquals("", signupState.getUsername());
    }

    @Test
    void getUsernameError() {
        assertEquals(null, signupState.getUsernameError());
    }

    @Test
    void getPassword() {
        assertEquals("", signupState.getPassword());
    }

    @Test
    void getPasswordError() {
        assertEquals("", signupState.getPassword());
    }

    @Test
    void getRepeatPassword() {
        assertEquals("", signupState.getRepeatPassword());
    }

    @Test
    void getRepeatPasswordError() {
        assertEquals(null, signupState.getRepeatPasswordError());
    }

    @Test
    void getGeneratedVerificationCode() {
        assertEquals("", signupState.getGeneratedVerificationCode());
    }

    @Test
    void getInputVerificationCode() {
        assertEquals("", signupState.getInputVerificationCode());
    }

    @Test
    void getEmail() {
        assertEquals("", signupState.getEmail());
    }

    @Test
    void setUsername() {
        signupState.setUsername("username");
    }

    @Test
    void setUsernameError() {
        assertEquals("", signupState.getUsername());
    }

    @Test
    void setPassword() {
        signupState.setPassword("password");
    }

    @Test
    void setPasswordError() {
        assertEquals("", signupState.getPassword());
    }

    @Test
    void setRepeatPassword() {
        signupState.setRepeatPassword("password");
    }

    @Test
    void setRepeatPasswordError() {
        signupState.setRepeatPassword("password");
    }

    @Test
    void setGeneratedVerificationCode() {
        signupState.setGeneratedVerificationCode("code");
    }

    @Test
    void setInputVerificationCode() {
        signupState.setInputVerificationCode("code");
    }

    @Test
    void setEmail() {
        signupState.setEmail("email");
    }
}