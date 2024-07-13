package use_case.view_product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublishQuestionOutputDataTest {

    PublishQuestionOutputData outputData;

    @BeforeEach
    void setUp() {
        outputData = new PublishQuestionOutputData("question successfully published");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOutputStr() {
        assertEquals("question successfully published", outputData.getOutputStr());
    }
}