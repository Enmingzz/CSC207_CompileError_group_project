package app.product_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
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
import interface_adapter.ViewManagerModel;
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
import interface_adapter.view_product.UnloggedInViewModel;
import use_case.search_product.*;
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
import use_case.shopping_cart.*;
import view.view_product.NonloggedInProductView;

import java.io.IOException;
import java.sql.SQLException;

public class NonLoggedInViewProductUseFactory {

    public static NonloggedInProductView create(ViewManagerModel viewManagerModel,
                                                MainPageViewModel mainPageViewModel,
                                                ShoppingCartViewModel shoppingCartViewModel,
                                                SearchProductViewModel searchProductViewModel,
                                                LoginViewModel loginViewModel,
                                                SignupViewModel signupViewModel,
                                                UnloggedInViewModel unloggedInViewModel) throws SQLException, IOException {
        ViewLoginPageController viewLoginPageController = createViewLoginPageController(loginViewModel, viewManagerModel);
        MainPageController mainPageController =
                NonLoggedInViewProductUseFactory.createMainPageController(mainPageViewModel, viewManagerModel);
        GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController = creatViewSignupPageController(viewManagerModel,signupViewModel);
        LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);
        ShoppingCartController shoppingCartController = createShoppingCartController(viewManagerModel, shoppingCartViewModel);

        return new NonloggedInProductView(unloggedInViewModel, viewLoginPageController, mainPageController, getSearchPageController, viewSignupPageController, shoppingCartController, logOutController);
    }

    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter(viewManagerModel,
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

    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
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

    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel,
                                                                         ViewManagerModel viewManagerModel){

        ViewLoginPageOutputBoundary viewLoginPagePresenter =
                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
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

    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) throws IOException, SQLException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, mainPageViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary userLoginInteractor = new LoginInteractor(userReadDataAccessInterface, loginOutputBoundary);

        return new LoginController(userLoginInteractor);
    }

}
