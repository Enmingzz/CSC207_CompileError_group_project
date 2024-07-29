package use_case.view_product;

import entity.comment.CommonAnswer;
import entity.comment.CommonQuestion;
import entity.comment.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReplyQuestionOutputDataTest {
    ReplyQuestionOutputData replyQuestionOutputData;

    @BeforeEach
    void setUp() {
        ArrayList<Question> questions = new ArrayList<>();
        Question question = new CommonQuestion("how much is it?", "1234567890",
                new CommonAnswer("", ""), "123");
        questions.add(question);
        replyQuestionOutputData = new ReplyQuestionOutputData("question successfully answered", questions);
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
        Question question = new CommonQuestion("how much is it?", "1234567890", new CommonAnswer("", ""), "123");
        assertEquals(question.getQuestionID(), replyQuestionOutputData.getQuestions().get(0).getQuestionID());
    }
}