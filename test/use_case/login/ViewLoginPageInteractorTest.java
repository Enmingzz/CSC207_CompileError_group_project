package use_case.login;

import interface_adapter.login.ViewLoginPageController;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.View;

import static org.junit.jupiter.api.Assertions.*;

class ViewLoginPageInteractorTest {

    private ViewLoginPageOutputBoundary viewLoginPagePresenter;
    private ViewLoginPageInteractor viewLoginPageInteractor;
    private ViewLoginPageInputData viewLoginPageInputData;

    @BeforeEach
    void setUp() {
        viewLoginPagePresenter = new ViewLoginPageOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewLoginPageOutputData viewLoginPageOutputData) {
                //assertEquals(viewLoginPageOutputData, new ViewLoginPageOutputData());
            }
        };
        viewLoginPageInteractor = new ViewLoginPageInteractor(viewLoginPagePresenter);
        viewLoginPageInputData= new ViewLoginPageInputData();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        viewLoginPageInteractor.execute(viewLoginPageInputData);
    }

}