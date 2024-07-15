package use_case.profile.modify_profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileOutputDataTest {
    private String message;
    private ModifyProfileOutputData modifyProfileOutputData;

    @BeforeEach
    void setUp() {
        message = "Test Message";
        modifyProfileOutputData = new ModifyProfileOutputData(message);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMessage() {
        assertEquals(message, modifyProfileOutputData.getMessage());
    }
}