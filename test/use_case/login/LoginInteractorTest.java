package use_case.login;

import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    private User commonUser;
    private String studentNumber = "123456";
    private String password;
    private InMemoryUserDataReadAccessObject inMemoryUserDataAccessObject;
    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp(){
        studentNumber = "123456";
        password = "123456";
        commonUser = new CommonUser("hanrui", password, "hanrui@mail", 0, studentNumber);
        UserFactory userFactory = new CommonUserFactory();
        ArrayList<User> users = new ArrayList<>();
        users.add(commonUser);
        inMemoryUserDataAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);

        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessfulView(LoginOutputData response) {
                assertEquals(response.getUser(), commonUser);
            }

            @Override
            public void prepareFailedView(String error) {
            }
        };

        this.loginInteractor = new LoginInteractor(inMemoryUserDataAccessObject, loginPresenter);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException {
        LoginInputData loginInputData = new LoginInputData(studentNumber, password);
        loginInteractor.execute(loginInputData);
    }

}