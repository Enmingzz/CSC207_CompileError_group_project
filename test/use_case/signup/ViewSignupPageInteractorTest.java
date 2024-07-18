package use_case.signup;

import interface_adapter.signup.ViewSignupPagePresenter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewSignupPageInteractorTest {

    private ViewSignupPageInteractor viewSignupPageInteractor;
    private ViewSignupPageInputData viewSignupPageInputData;

    @BeforeEach
    void setUp() {
        viewSignupPageInputData = new ViewSignupPageInputData();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {

        ViewSignupPageOutputBoundary viewSignupPagePresenter = new ViewSignupPageOutputBoundary(){

            @Override
            public void prepareSuccessfulView(ViewSignupPageOutputData viewSignupPageOutputData) {
                assertEquals(new ViewSignupPageOutputData(), viewSignupPageOutputData);
            }
        };

        viewSignupPageInteractor = new ViewSignupPageInteractor(viewSignupPagePresenter);
        viewSignupPageInteractor.execute(viewSignupPageInputData);
    }

}