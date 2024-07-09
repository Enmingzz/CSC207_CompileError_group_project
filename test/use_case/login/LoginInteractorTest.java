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
    private ArrayList<User> users;
    private UserFactory userFactory;

    @BeforeEach
    void setUp(){
        studentNumber = "123456";
        password = "123456";
        userFactory = new CommonUserFactory();
        users = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successfulView() throws SQLException {
        commonUser = new CommonUser("hanrui", password, "hanrui@mail", 0, studentNumber);
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
        LoginInputData loginInputData = new LoginInputData(studentNumber, password);
        loginInteractor.execute(loginInputData);
    }

    @Test
    void canNotFindUserFailedView() throws SQLException {
        commonUser = new CommonUser("nothanrui", password, "hanrui@mail", 0, studentNumber);
        users.add(commonUser);
        inMemoryUserDataAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);

        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessfulView(LoginOutputData response) {
            }

            @Override
            public void prepareFailedView(String error) {
                assertEquals("Can not find user", error);
            }
        };

        this.loginInteractor = new LoginInteractor(inMemoryUserDataAccessObject, loginPresenter);
        LoginInputData loginInputData = new LoginInputData(studentNumber, password);
        loginInteractor.execute(loginInputData);
    }

    @Test
    void passwordDoesNotMatch() throws SQLException {
        commonUser = new CommonUser("hanrui", password+"222", "hanrui@mail", 0, studentNumber);
        users.add(commonUser);
        inMemoryUserDataAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);

        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessfulView(LoginOutputData response) {
            }

            @Override
            public void prepareFailedView(String error) {
                assertEquals("Passwords do not match", error);
            }
        };

        this.loginInteractor = new LoginInteractor(inMemoryUserDataAccessObject, loginPresenter);
        LoginInputData loginInputData = new LoginInputData(studentNumber, password);
        loginInteractor.execute(loginInputData);
    }

}