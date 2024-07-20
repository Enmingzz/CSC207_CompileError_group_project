package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.*;
import interface_adapter.login.*;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import interface_adapter.view_product.BuyerViewProductViewModel;
import use_case.search_product.*;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import use_case.login.*;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.login.LoginView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginView create(ViewManagerModel viewManagerModel,
                                   LoginViewModel loginViewModel,
                                   MainPageViewModel mainPageViewModel,
                                   ShoppingCartViewModel shoppingCartViewModel,
                                   ViewProfileViewModel profileViewModel,
                                   BuyerViewProductViewModel buyerViewProductViewModel,
                                   SearchProductViewModel searchProductViewModel,
                                   SignupViewModel signupViewModel) {

        try {
            LoginController loginController = createUserLoginUseCase(viewManagerModel, loginViewModel, mainPageViewModel);

            GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);

            ViewSignupPageController viewSignupPageController = createViewSignupPageController(viewManagerModel, signupViewModel);

            ViewLoginPageController viewLoginPageController = createViewLoginPageController(loginViewModel, viewManagerModel);
            ShoppingCartController shoppingCartController = createShoppingCartController(viewManagerModel, shoppingCartViewModel);
            LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);

            ViewProfileController viewProfileController = createProfileController(viewManagerModel, profileViewModel);

            MainPageController mainPageController = createMainPageController(mainPageViewModel, viewManagerModel);
            return new LoginView( loginViewModel,
                    loginController,
                    mainPageController,
                    getSearchPageController,
                    viewSignupPageController,
                    viewLoginPageController,
                    shoppingCartController,
                    logOutController,
                    viewProfileController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static ViewSignupPageController createViewSignupPageController(ViewManagerModel viewManagerModel,
                                                                           SignupViewModel signupViewModel) throws SQLException{
        ViewSignupPageOutputBoundary preseter = new ViewSignupPagePresenter(viewManagerModel, signupViewModel);

        ViewSignupPageInputBoundary interactor = new ViewSignupPageInteractor(preseter);
        return new ViewSignupPageController(interactor);
    }
    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) throws IOException, SQLException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, mainPageViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary userLoginInteractor = new LoginInteractor(userReadDataAccessInterface, loginOutputBoundary);

        return new LoginController(userLoginInteractor);
    }

    /**
     * Creates an instance of {@link ShoppingCartController}.
     *
     * @param viewManagerModel     the view manager model
     * @param shoppingCartViewModel the shopping cart view model
     * @return an instance of {@link ShoppingCartController}
     * @throws SQLException if a database access error occurs
     */

    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShowShoppingCartOutputBoundary presenter = new ShoppingCartPresenter(viewManagerModel,
                shoppingCartViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory, scheduleFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());
        DatabaseShoppingCartCreateDataAccessObjectFactoryInterface databaseShoppingCartCreateDataAccessObjectFactory =
                new DatabaseShoppingCartCreateDataAccessObjectFactory();
        ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject =
                databaseShoppingCartCreateDataAccessObjectFactory.create();

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory, shoppingCartCreateDataAccessObject);

        return new SignupController(userSignupInteractor);
    }

    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }

    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter, productReadAllDataAccessObeject);
        return new MainPageController(showMainPageInteractor);
    }

    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    private static GetSearchPageController createGetSearchPageController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        GetSearchViewOutputBoundary getSearchViewPresenter =
                new GetSearchPagePresenter(searchProductViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        GetSearchViewInputBoundary getSearchViewInteractor =
                new GetSearchViewInteractor(getSearchViewPresenter, productReadAllDataAccessObeject);
        return new GetSearchPageController(getSearchViewInteractor);
    }

    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel,
                                                                         ViewManagerModel viewManagerModel){

        ViewLoginPageOutputBoundary viewLoginPagePresenter =
                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }


}