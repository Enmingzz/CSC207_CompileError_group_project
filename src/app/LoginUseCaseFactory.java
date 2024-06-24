package app;

import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.*;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.login.LoginView;

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

    private static ShoppingCartController createShoppingCartController() throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter();
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

}