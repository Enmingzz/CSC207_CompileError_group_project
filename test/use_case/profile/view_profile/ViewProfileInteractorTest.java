package use_case.profile.view_profile;

import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewProfileInteractorTest {
    private ViewProfileOutputBoundary viewProfileOutputBoundary;

    private ViewProfileInputBoundary viewProfileInteractor;
    private ViewProfileInputData viewProfileInputData;

    private User user;


    @BeforeEach
    void setUp() {
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        viewProfileInputData = new ViewProfileInputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        viewProfileOutputBoundary = new ViewProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewProfileOutputData viewProfileOutputData) {
                assertEquals(user, viewProfileOutputData.getUser());
            }
        };

        viewProfileInteractor = new ViewProfileInteractor(viewProfileOutputBoundary);

        viewProfileInteractor.execute(viewProfileInputData);
    }
}