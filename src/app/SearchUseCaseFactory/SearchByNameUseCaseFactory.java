package app.SearchUseCaseFactory;

import data_access.factories.interfaces.Product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.Product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.Product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.Prouct.ProductReadAllDataAccessInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.User.UserCreateDataAccessInterface;
import data_access.interfaces.User.UserReadDataAccessInterface;
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
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByNamePresenter;
import interface_adapter.search_product.SearchProductByNameViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.Signup.SignupInputBoundary;
import use_case.Signup.SignupInteractor;
import use_case.Signup.SignupOutputBoundary;
import use_case.login.*;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.product_search.SearchProductByNameInputBoundary;
import use_case.product_search.SearchProductByNameInteractor;
import use_case.product_search.SearchProductByNameOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.product_search.SearchByNameView;

import java.io.IOException;
import java.sql.SQLException;

public class SearchByNameUseCaseFactory {

    public static SearchByNameView create(){
        //TODO implements this method
        return new SearchByNameView();
    }

    private static SearchProductByNameController createSearchProductByNameController(ViewManagerModel viewManagerModel, SearchProductByNameViewModel searchProductByNameViewModel) throws SQLException {
        SearchProductByNameOutputBoundary searchProductByNamePresenter =
                new SearchProductByNamePresenter(viewManagerModel, searchProductByNameViewModel);
        DatabaseProductReadByNameDataAccessObjectFactoryInterface databaseProductReadByNameDataAccessObjectFactory
                = new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByNameDataAccessInterface productReadByNameDataAccessObject =
                databaseProductReadByNameDataAccessObjectFactory.create(productFactory, scheduleFactory);
        SearchProductByNameInputBoundary searchProductByNameInteractor =
                new SearchProductByNameInteractor(productReadByNameDataAccessObject,
                        searchProductByNamePresenter);
        return new SearchProductByNameController(searchProductByNameInteractor);
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

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory
                = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject =
                databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new
                SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory =
                new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface =
                databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

    private static ViewLoginPageController createViewLoginPageController(){

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter();
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



}
