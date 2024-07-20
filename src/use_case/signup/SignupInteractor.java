package use_case.signup;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Receives student's information from the SignUpView, processes the information, and executes
 * different actions based on the validation results.
 * If the user does not exist, the passwords match, and the verification code matches, then executes the
 * successful view presenter.
 * Otherwise, executes the failed view presenter with different error messages.
 */
public class SignupInteractor implements SignupInputBoundary {
    final UserCreateDataAccessInterface userCreateDataAccessObject;
    final UserReadDataAccessInterface userReadDataAccessObject;
    final ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject;
    final SignupOutputBoundary signupPresenter;
    final UserFactory userFactory;

    /**
     * Constructs a SignupInteractor with the given data access objects, presenter, and user factory.
     *
     * @param userCreateDataAccessObject A DAO used to save a user into the database.
     * @param userReadDataAccessObject A DAO used to read users from the database.
     * @param signupPresenter The presenter for handling the signup output.
     * @param userFactory The factory for creating user objects.
     */
    public SignupInteractor(UserCreateDataAccessInterface userCreateDataAccessObject, UserReadDataAccessInterface userReadDataAccessObject,
                            SignupOutputBoundary signupPresenter,
                            UserFactory userFactory,
                            ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject) {
        this.userCreateDataAccessObject = userCreateDataAccessObject;
        this.userReadDataAccessObject = userReadDataAccessObject;
        this.signupPresenter = signupPresenter;
        this.userFactory = userFactory;
        this.shoppingCartCreateDataAccessObject = shoppingCartCreateDataAccessObject;
    }

    /**
     * Checks if a user exists by their student number.
     *
     * @param signupInputData the signup input data
     * @return true if the user exists, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean existsByStudentNumber(SignupInputData signupInputData) throws SQLException {
        User user = userReadDataAccessObject.getUser(signupInputData.getStudentNumber());
        return user != null;
    }

    /**
     * Executes the signup process.
     * Validates the input data and either creates a new user or returns an error message.
     *
     * @param signupInputData the signup input data
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void execute(SignupInputData signupInputData) throws SQLException {
        User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(),
                signupInputData.getEmailAddress(), 0, signupInputData.getStudentNumber());

        if (existsByStudentNumber(signupInputData)) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "user already exists");
            signupPresenter.presentFailedView(signupOutputData);
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "passwords do not match");
            signupPresenter.presentFailedView(signupOutputData);
        } else if (signupInputData.getGeneratedVerificationCode().isEmpty()) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "need to send verification code first");
            signupPresenter.presentFailedView(signupOutputData);
        } else if (!signupInputData.getInputVerificationCode().equals(signupInputData.getGeneratedVerificationCode())) {
            SignupOutputData signupOutputData = new SignupOutputData(user, "wrong verification code");
            signupPresenter.presentFailedView(signupOutputData);
        } else {
            userCreateDataAccessObject.saveUser(user);
            shoppingCartCreateDataAccessObject.saveShoppingCart(user);

            SignupOutputData signupOutputData = new SignupOutputData(user, "successful");
            signupPresenter.presentSuccessfulView(signupOutputData);
        }
    }
}
