package use_case.view_product;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublishQuestionOutputDataTest {

    PublishQuestionOutputData outputData;

    @BeforeEach
    void setUp() {
        User commonUser = new CommonUser("hanrui", "222", "hanrui@mail", 0, "123");

        outputData = new PublishQuestionOutputData("question successfully published", "new question", commonUser, outputData.getQuestion());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOutputStr() {
        assertEquals("question successfully published", outputData.getOutputStr());
    }
}