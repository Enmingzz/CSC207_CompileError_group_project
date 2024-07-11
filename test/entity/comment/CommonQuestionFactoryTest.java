package entity.comment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonQuestionFactoryTest {

    private QuestionFactory commonQuestionFactory;
    private Question commonQuestion;
    private Answer commonAnswer;

    @BeforeEach
    void setUp() {
        commonQuestionFactory = new CommonQuestionFactory();
        commonAnswer = new CommonAnswer("test answer", "123456");
        commonQuestion = new CommonQuestion("test question", "123456", commonAnswer, "123456");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createQuestion() {
        Question newQuestion = commonQuestionFactory.createQuestion("test question", "123456",
                commonAnswer, "123456");
        assertEquals(commonQuestion, newQuestion);
    }

}