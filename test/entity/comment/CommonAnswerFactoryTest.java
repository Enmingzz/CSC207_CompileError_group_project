package entity.comment;

import entity.user.CommonUser;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonAnswerFactoryTest {
    private Answer answer;
    private AnswerFactory commonAnswerFactory;

    @BeforeEach
    void setUp() {
        answer = new CommonAnswer("this is a test", "123456");
        this.commonAnswerFactory = new CommonAnswerFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createAnswer() {
        Answer newAnswer = commonAnswerFactory.createAnswer("this is a test", "123456");
        assertEquals(answer, newAnswer);
    }
}