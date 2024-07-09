package entity.comment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonCommentTest {

    private Comment commonCommment;

    @BeforeEach
    void setUp() {
        commonCommment = new CommonComment("this is a test", "123456");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescription() {
        assertEquals("this is a test", this.commonCommment.getDescription());
    }

    @Test
    void getStudentNumber() {
        assertEquals("123456", this.commonCommment.getStudentNumber());
    }
}