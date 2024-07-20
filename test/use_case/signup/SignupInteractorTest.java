package use_case.signup;

import data_access.in_memory.user.InMemoryUserCreateDataAccessObject;
import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
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

class SignupInteractorTest {

    private SignupInteractor signupInteractor;
    private User user;
    private SignupInputData signupInputData;
    private SignupOutputData signupOutputData;
    private UserReadDataAccessInterface inMemoryUserDataReadAccessObject;
    private UserCreateDataAccessInterface inMemoryUserCreateDataAccessObject;
    private ShoppingCartCreateDataAccessInterface inMemoryShoppingCartCreateDataAccessObject;
    private ArrayList<User> users;
    private UserFactory userFactory;
    private SignupOutputBoundary signupPresenter;

    @BeforeEach
    void setUp() {
        userFactory = new CommonUserFactory();
        users = new ArrayList<User>();
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "11111");
        users.add(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void existsByStudentNumber() throws SQLException {
        inMemoryUserCreateDataAccessObject =
                new InMemoryUserCreateDataAccessObject(new ArrayList<User>());
        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        assertEquals(true, inMemoryUserDataReadAccessObject.getUser("11111"));
        signupPresenter = new SignupOutputBoundary() {
            @Override
            public void presentSuccessfulView(SignupOutputData response) {

            }

            @Override
            public void presentFailedView(SignupOutputData response) {
                assertEquals("user already exists", response.getError());
            }
        };
    }

    @Test
    void successfulView() throws SQLException {
        signupInputData = new SignupInputData("hanrui", "123456", "123456", "hanrui@mail",
                "1234","1234",
                "11111");
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "11111");
        users.add(user);
        signupPresenter = new SignupOutputBoundary() {
            @Override
            public void presentSuccessfulView(SignupOutputData response) {
                assertEquals("no error", response.getError());
                assertEquals(user, response.getUser());
            }

            @Override
            public void presentFailedView(SignupOutputData response) {

            }
        };

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        signupInteractor = new SignupInteractor(inMemoryUserCreateDataAccessObject,
         inMemoryUserDataReadAccessObject, signupPresenter, userFactory, inMemoryShoppingCartCreateDataAccessObject);
        signupInteractor.execute(signupInputData);
    }

    @Test
    void passwordDoesNotMatch() throws SQLException {
        signupInputData = new SignupInputData("hanrui", "123456", "123", "hanrui@mail",
                "1234","1234",
                "11111");
        signupPresenter = new SignupOutputBoundary() {

            @Override
            public void presentSuccessfulView(SignupOutputData response) {

            }

            @Override
            public void presentFailedView(SignupOutputData response) {
                assertEquals("password does not match", response.getError());
            }
        };

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        signupInteractor = new SignupInteractor(inMemoryUserCreateDataAccessObject,
                inMemoryUserDataReadAccessObject, signupPresenter, userFactory, inMemoryShoppingCartCreateDataAccessObject);
        signupInteractor.execute(signupInputData);
    }

    @Test
    void validationCodeDoesNotMatch() throws SQLException {
        signupInputData = new SignupInputData("hanrui", "123456", "123456", "hanrui@mail",
                "1234","1234",
                "11111");

        signupPresenter = new SignupOutputBoundary() {

            @Override
            public void presentSuccessfulView(SignupOutputData response) {

            }

            @Override
            public void presentFailedView(SignupOutputData response) {
                assertEquals("Wrong verification code", response.getError());
            }
        };

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        signupInteractor = new SignupInteractor(inMemoryUserCreateDataAccessObject,
                inMemoryUserDataReadAccessObject, signupPresenter, userFactory, inMemoryShoppingCartCreateDataAccessObject);
        signupInteractor.execute(signupInputData);
    }

    @Test
    void userDoesExit() throws SQLException {
        signupInputData = new SignupInputData("hanrui", "123456", "123456", "hanrui@mail",
                "1234","1234",
                "12345");

        signupPresenter = new SignupOutputBoundary() {

            @Override
            public void presentSuccessfulView(SignupOutputData response) {

            }

            @Override
            public void presentFailedView(SignupOutputData response) {
                assertEquals("user already exists", response.getError());
            }
        };

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        signupInteractor = new SignupInteractor(inMemoryUserCreateDataAccessObject,
                inMemoryUserDataReadAccessObject, signupPresenter, userFactory, inMemoryShoppingCartCreateDataAccessObject);
        signupInteractor.execute(signupInputData);

    }

    @Test
    void haveNotSendValidationCode() throws SQLException {
        signupInputData = new SignupInputData("hanrui", "123456", "123456", "hanrui@mail",
                "1234","",
                "11111");

        signupPresenter = new SignupOutputBoundary() {

            @Override
            public void presentSuccessfulView(SignupOutputData response) {

            }

            @Override
            public void presentFailedView(SignupOutputData response) {
                assertEquals("Need to send verification code fist", response.getError());
            }
        };

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        signupInteractor = new SignupInteractor(inMemoryUserCreateDataAccessObject,
                inMemoryUserDataReadAccessObject, signupPresenter, userFactory, inMemoryShoppingCartCreateDataAccessObject);
        signupInteractor.execute(signupInputData);
    }

}