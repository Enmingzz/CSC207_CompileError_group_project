package app;

import data_access.factories.interfaces.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.UserCreateDataAccessInterface;
import data_access.interfaces.UserReadDataAccessInterface;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.*;
import use_case.*;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class SignupUseCaseFactory {

    private SignupUseCaseFactory() {
    }

    public static SignupView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            EmailVerificationController emailVerificationController = SignupUseCaseFactory.createEmailVerifyUseCase(viewManagerModel, signupViewModel);
            return new SignupView(signupController, signupViewModel, emailVerificationController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

    private static EmailVerificationController createEmailVerifyUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        EmailVerificationOutputBoundary emailVerificationOutputBoundary = new EmailVerificationPresenter(viewManagerModel, signupViewModel);
        EmailVerificationInputBoundary emailVerificationInteractor = new EmailVerificationInteractor(emailVerificationOutputBoundary);
        return new EmailVerificationController(emailVerificationInteractor);
    }
}

