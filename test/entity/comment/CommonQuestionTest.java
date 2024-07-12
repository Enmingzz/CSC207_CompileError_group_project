package entity.comment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CommonQuestionTest {

    private Question commonQuestion;
    private Answer commonAnswer;

    @BeforeEach
    void setUp() {
        commonAnswer = new CommonAnswer("test answer", "123456");
        commonQuestion = new CommonQuestion("test question", "123456", commonAnswer, "12");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescription() {
        assertEquals("test question", commonQuestion.getDescription());
    }

    @Test
    void getStudentNumber() {
        assertEquals("123456", commonQuestion.getStudentNumber());
    }

    @Test
    void getAnswer() {
        assertEquals(commonAnswer, commonQuestion.getAnswer());
    }

    @Test
    void getQuestionId() {
        assertEquals("12", commonQuestion.getQuestionID());
    }

}