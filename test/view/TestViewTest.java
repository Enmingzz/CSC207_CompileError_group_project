package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class TestViewTest {

    private TestView view;

    @BeforeEach
    void setUp() {
        view = new TestView();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
        view.propertyChange(new PropertyChangeEvent("hi", "1", "2", "3"));
    }

    @Test
    void propertyChange() {
    }
}