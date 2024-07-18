package app.schedule_usecase_factory;

import app.search_product_usecase_factory.SearchProductUseCaseFactory;
import data_access.factories.interfaces.product.*;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.*;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.interfaces.product.*;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectSchedulePresenter;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.signup.ViewSignupPagePresenter;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.schedule.BuyerSelectScheduleOutputBoundary;
import use_case.search_product.*;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInteractor;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.ViewSignupPageInputBoundary;
import use_case.signup.ViewSignupPageInteractor;
import use_case.signup.ViewSignupPageOutputBoundary;
import view.schedule.BuyerScheduleView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The BuyerScheduleUseCaseFactory class is responsible for creating the BuyerScheduleView
 * along with its necessary controllers and view models.
 */
public class BuyerScheduleUseCaseFactory {

    /**
     * Creates and returns a BuyerScheduleView with the specified view models and controllers.
     *
     * @param buyerSelectScheduleViewModel the view model for buyer select schedule
     * @param shoppingCartViewModel the view model for the shopping cart
     * @param viewManagerModel the view manager model
     * @param signupViewModel the view model for signup
     * @param loginViewModel the view model for login
     * @param searchProductViewModel the view model for search product
     * @param mainPageViewModel the view model for main page
     * @param viewProfileViewModel the view model for view profile
     * @return the created BuyerScheduleView
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public static BuyerScheduleView create(BuyerSelectScheduleViewModel buyerSelectScheduleViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           ViewManagerModel viewManagerModel,
                                           SignupViewModel signupViewModel,
                                           LoginViewModel loginViewModel,
                                           SearchProductViewModel searchProductViewModel,
                                           MainPageViewModel mainPageViewModel,
                                           ViewProfileViewModel viewProfileViewModel) throws SQLException, IOException {
        BuyerSelectScheduleController buyerSelectScheduleController =
                BuyerScheduleUseCaseFactory.createBuyerSelectScheduleController(buyerSelectScheduleViewModel,
                        viewManagerModel, shoppingCartViewModel);
        ShoppingCartController shoppingCartController =
                BuyerScheduleUseCaseFactory.createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        GetSearchPageController getSearchPageController =
                BuyerScheduleUseCaseFactory.createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController =
                BuyerScheduleUseCaseFactory.creatViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController =
                BuyerScheduleUseCaseFactory.createViewLoginPageController(loginViewModel, viewManagerModel);
        LogOutController logOutController =
                BuyerScheduleUseCaseFactory.createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController =
                BuyerScheduleUseCaseFactory.createProfileController(viewManagerModel, viewProfileViewModel);
        MainPageController mainPageController =
                BuyerScheduleUseCaseFactory.createMainPageController(mainPageViewModel, viewManagerModel);
        return new BuyerScheduleView(buyerSelectScheduleViewModel, buyerSelectScheduleController, shoppingCartController,
                getSearchPageController, viewSignupPageController, viewLoginPageController, logOutController,
                viewProfileController, mainPageController);

    }

    /**
     * Creates and returns a BuyerSelectScheduleController with the specified view models.
     *
     * @param buyerSelectScheduleViewModel the view model for buyer select schedule
     * @param viewManagerModel the view manager model
     * @param shoppingCartViewModel the view model for the shopping cart
     * @return the created BuyerSelectScheduleController
     * @throws SQLException if a database access error occurs
     */
    private static BuyerSelectScheduleController createBuyerSelectScheduleController
            (BuyerSelectScheduleViewModel buyerSelectScheduleViewModel, ViewManagerModel viewManagerModel,
             ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        BuyerSelectScheduleOutputBoundary buyerSelectSchedulePresenter =
                new BuyerSelectSchedulePresenter(buyerSelectScheduleViewModel, viewManagerModel, shoppingCartViewModel);
        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactoryInterface =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface dataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory();
        ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerScheduleDataAccessObject =
                dataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface.create();
        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateStateDataAccessObjectFactory();
        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactoryInterface.create();
        BuyerSelectScheduleInputBoundary buyerSelectScheduleInteractor =
                new BuyerSelectScheduleInteractor(buyerSelectSchedulePresenter, productReadByIdDataAccessObject,
                        productUpdateBuyerScheduleDataAccessObject, productUpdateStateDataAccessObject);
        return new BuyerSelectScheduleController(buyerSelectScheduleInteractor);
    }

    /**
     * Creates and returns a MainPageController with the specified view models.
     *
     * @param mainPageViewModel the view model for main page
     * @param viewManagerModel the view manager model
     * @return the created MainPageController
     * @throws SQLException if a database access error occurs
     */
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

    /**
     * Creates and returns a LogOutController with the specified view models.
     *
     * @param viewManagerModel the view manager model
     * @param mainPageViewModel the view model for main page
     * @return the created LogOutController
     * @throws SQLException if a database access error occurs
     */
    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    /**
     * Creates and returns a ViewProfileController.
     *
     * @param viewManagerModel the view manager model
     * @param profileViewModel the view model for view profile
     * @return the created ViewProfileController
     * @throws IOException if an I/O error occurs
     * */
    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Creates and returns a GetSearchPageController.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the view model for search product
     * @return the created GetSearchPageController
     * @throws SQLException if a database access error occurs
     */
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

    /**
     * Creates and returns a ShoppingCartController.
     *
     * @param viewManagerModel the view manager model
     * @param shoppingCartViewModel the view model for the shopping cart
     * @return the created ShoppingCartController
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


    /**
     * Creates and returns a ViewLoginPageController.
     *
     * @param loginViewModel the view model for login
     * @param viewManagerModel the view manager model
     * @return the created ViewLoginPageController
     * @throws SQLException if a database access error occurs
     */
    private static ViewLoginPageController createViewLoginPageController
            (LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) throws SQLException {

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates and returns a ViewSignupPageController.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel the view model for signup
     * @return the created ViewSignupPageController
     */
    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }
}
