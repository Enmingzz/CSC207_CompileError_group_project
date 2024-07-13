package use_case.view_product;

import entity.comment.CommonQuestion;
import entity.comment.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplyQuestionOutputDataTest {
    ReplyQuestionOutputData replyQuestionOutputData;

    @BeforeEach
    void setUp() {
        Question question = new CommonQuestion("how much is it?", "1234567890", null, "123");
        replyQuestionOutputData = new ReplyQuestionOutputData("question successfully answered", question);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOutputStr() {
        assertEquals("question successfully answered", replyQuestionOutputData.getOutputStr());
    }

    @Test
    void getQuestion() {
        Question question = new CommonQuestion("how much is it?", "1234567890", null, "123");
        assertEquals(question, replyQuestionOutputData.getQuestion());
    }
}