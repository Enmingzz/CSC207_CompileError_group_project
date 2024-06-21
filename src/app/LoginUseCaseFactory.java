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
import view.LoginView;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) {

        try {
            LoginController loginController = createUserLoginUseCase(viewManagerModel, loginViewModel, mainPageViewModel);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) throws IOException, SQLException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, mainPageViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary userLoginInteractor = new LoginInteractor(userReadDataAccessInterface, loginOutputBoundary, userFactory);

        return new LoginController(userLoginInteractor);
    }
}