package use_case.view_product;

import entity.comment.CommonAnswer;
import entity.comment.CommonQuestion;
import entity.comment.Question;
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
        Question question = new CommonQuestion("description", "123", new CommonAnswer("111",
                "111"), "123345");
        outputData = new PublishQuestionOutputData("question successfully published", "new " +
                "question", commonUser, question);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOutputStr() {
        assertEquals("question successfully published", outputData.getOutputStr());
    }
}