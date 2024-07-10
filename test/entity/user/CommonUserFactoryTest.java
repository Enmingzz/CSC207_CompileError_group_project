package entity.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserFactoryTest {

    User commonUser;
    UserFactory commonUserFactory;

    @BeforeEach
    void setUp() {
        commonUser = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        commonUserFactory = new CommonUserFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        User newUser = commonUserFactory.createUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        assertEquals(commonUser, newUser);
    }

}