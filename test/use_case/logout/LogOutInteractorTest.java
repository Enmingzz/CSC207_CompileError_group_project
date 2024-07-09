package use_case.logout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogOutInteractorTest {

    private LogOutInteractor logOutInteractor;
    private LogOutOutputBoundary logOutOutputPresenter;
    private LogOutInputData logOutInputData;

    @BeforeEach
    void setUp() {
        logOutOutputPresenter = new LogOutOutputBoundary() {
            @Override
            public void prepareSuccessfulView(LogOutOutputData logOutOutputData) {
                assertEquals(new LogOutOutputData(), logOutOutputData);
            }
        };

        logOutInputData = new LogOutInputData();
        logOutInteractor = new LogOutInteractor(logOutOutputPresenter);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        logOutInteractor.execute(logOutInputData);
    }

}