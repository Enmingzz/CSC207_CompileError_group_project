package use_case.profile.modify_profile;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileInputDataTest {
    private ModifyProfileInputData modifyProfileInputData;
    private User user;

    @BeforeEach
    void setUp() {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertEquals(user, modifyProfileInputData.getUser());
    }
}