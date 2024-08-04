package entity.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {

    User commonUser;

    @BeforeEach
    void setUp() {
        commonUser = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        assertEquals("hanrui", commonUser.getName());
    }

    @Test
    void getPassword() {
        assertEquals("123456", commonUser.getPassword());
    }

    @Test
    void getEmail() {
        assertEquals("hanrui@mail", commonUser.getEmail());
    }

    @Test
    void getUserRating() {
        assertEquals(0, commonUser.getUserRating());
    }

    @Test
    void getStudentNumber() {
        assertEquals("123456", commonUser.getStudentNumber());
    }

}