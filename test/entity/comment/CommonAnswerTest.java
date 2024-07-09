package entity.comment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonAnswerTest {

    private Answer commonAnswer;

    @BeforeEach
    void setUp() {
        this.commonAnswer = new CommonAnswer("this ia test", "123456");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescription() {
        assertEquals("this ia test", commonAnswer.getDescription());
    }

    @Test
    void getStudentNumber() {
        assertEquals("123456", commonAnswer.getStudentNumber());
    }
}