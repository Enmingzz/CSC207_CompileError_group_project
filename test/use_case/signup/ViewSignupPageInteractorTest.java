package use_case.signup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                assert(true);
            }
        };

        viewSignupPageInteractor = new ViewSignupPageInteractor(viewSignupPagePresenter);
        viewSignupPageInteractor.execute(viewSignupPageInputData);
    }

}