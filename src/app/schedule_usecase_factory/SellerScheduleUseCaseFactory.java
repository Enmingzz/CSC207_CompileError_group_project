package app.schedule_usecase_factory;

import app.search_product_usecase_factory.SearchProductUseCaseFactory;
import data_access.factories.interfaces.product.*;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.*;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.*;
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
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.SellerSelectScheduleController;
import interface_adapter.schedule.SellerSelectSchedulePresenter;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.search_product.*;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInteractor;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import view.schedule.SellerScheduleView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The SellerScheduleUseCaseFactory class is responsible for creating the SellerScheduleView
 * along with its necessary controllers and view models.
 */
public class SellerScheduleUseCaseFactory {

    /**
     * Creates and returns a SellerScheduleView with the specified view models and controllers.
     *
     * @param sellerSelectScheduleViewModel the view model for seller select schedule
     * @param viewManagerModel              the view manager model
     * @param manageProductViewModel        the view model for managing products
     * @param signupViewModel               the view model for signup
     * @param loginViewModel                the view model for login
     * @param shoppingCartViewModel         the view model for the shopping cart
     * @param mainPageViewModel             the view model for the main page
     * @param searchProductViewModel        the view model for search product
     * @param viewProfileViewModel          the view model for view profile
     * @return the created SellerScheduleView
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public static SellerScheduleView create(SellerSelectScheduleViewModel sellerSelectScheduleViewModel,
                                            ViewManagerModel viewManagerModel,
                                            ManageProductViewModel manageProductViewModel,
                                            SignupViewModel signupViewModel,
                                            LoginViewModel loginViewModel,
                                            ShoppingCartViewModel shoppingCartViewModel,
                                            MainPageViewModel mainPageViewModel,
                                            SearchProductViewModel searchProductViewModel,
                                            ViewProfileViewModel viewProfileViewModel) throws SQLException, IOException {
        SellerSelectScheduleController sellerSelectScheduleController =
                SellerScheduleUseCaseFactory.createSellerSelectScheduleController(sellerSelectScheduleViewModel,
                        viewManagerModel, manageProductViewModel);
        ManageProductController manageProductController =
                SellerScheduleUseCaseFactory.createManageProductController(viewManagerModel, manageProductViewModel);
        GetSearchPageController getSearchPageController =
                SellerScheduleUseCaseFactory.createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController =
                SellerScheduleUseCaseFactory.creatViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController =
                SellerScheduleUseCaseFactory.createViewLoginPageController(loginViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController =
                SellerScheduleUseCaseFactory.createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        LogOutController logOutController =
                SellerScheduleUseCaseFactory.createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController =
                SellerScheduleUseCaseFactory.createProfileController(viewManagerModel, viewProfileViewModel);
        MainPageController mainPageController =
                SellerScheduleUseCaseFactory.createMainPageController(mainPageViewModel, viewManagerModel);
        return new SellerScheduleView(sellerSelectScheduleController, sellerSelectScheduleViewModel, manageProductController,
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController,
                viewProfileController, mainPageController);

    }

    /**
     * Creates an instance of {@link SellerSelectScheduleController}.
     *
     * @param sellerSelectScheduleViewModel the view model for seller select schedule
     * @param viewManagerModel              the view manager model
     * @param manageProductViewModel        the manage product view model
     * @return an instance of {@link SellerSelectScheduleController}
     * @throws SQLException if a database access error occurs
     */
    private static SellerSelectScheduleController createSellerSelectScheduleController
            (SellerSelectScheduleViewModel sellerSelectScheduleViewModel, ViewManagerModel viewManagerModel,
             ManageProductViewModel manageProductViewModel) throws SQLException {
        SellerSelectScheduleOutputBoundary sellerSelectSchedulePresenter =
                new SellerSelectSchedulePresenter(sellerSelectScheduleViewModel, manageProductViewModel, viewManagerModel);
        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactoryInterface =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface dataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateSellerScheduleDataAccessObjectFactory();
        ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerScheduleDataAccessObject =
                dataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface.create();
        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateStateDataAccessObjectFactory();
        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactoryInterface.create();
        SellerSelectScheduleInputBoundary sellerSelectScheduleInteractor =
                new SellerSelectScheduleInteractor(sellerSelectSchedulePresenter, productReadByIdDataAccessObject,
                        productUpdateSellerScheduleDataAccessObject, productUpdateStateDataAccessObject);
        return new SellerSelectScheduleController(sellerSelectScheduleInteractor);
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

    /**
     * Creates an instance of {@link MainPageController}.
     *
     * @param mainPageViewModel   the main page view model
     * @param viewManagerModel    the view manager model
     * @return an instance of {@link MainPageController}
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
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel  the view manager model
     * @param mainPageViewModel the main page view model
     * @return an instance of {@link LogOutController}
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
     * Creates an instance of {@link ManageProductController}.
     *
     * @param viewManagerModel       the view manager model
     * @param manageProductViewModel the manage product view model
     * @return an instance of {@link ManageProductController}
     * @throws SQLException if a database access error occurs
     */
    private static ManageProductController createManageProductController(ViewManagerModel viewManagerModel,
                                                                         ManageProductViewModel manageProductViewModel) throws SQLException {
        ManageProductOutputBoundary manageProductPresenter =
                new ManageProductPresenter(viewManagerModel, manageProductViewModel);
        DatabaseProductReadByUserDataAccessObjectFactoryInterface databaseProductReadByUserDataAccessObjectFactoryInterface =
                new DatabaseProductReadByUserDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByUserDataAccessInterface productReadByUserDataAccessObject =
                databaseProductReadByUserDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ManageProductInputBoundary manageProductInteractor =
                new ManageProductInteractor(manageProductPresenter, productReadByUserDataAccessObject);
        return new ManageProductController(manageProductInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel       the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link GetSearchPageController}
     * @throws SQLException if a database access error occurs
     */
    private static GetSearchPageController createGetSearchPageController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        GetSearchViewOutputBoundary getSearchViewPresenter =
                new GetSearchPagePresenter(searchProductViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface =
                new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        GetSearchViewInputBoundary getSearchViewInteractor =
                new GetSearchViewInteractor(getSearchViewPresenter, productReadAllDataAccessObeject);
        return new GetSearchPageController(getSearchViewInteractor);
    }

    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel     the login view model
     * @param viewManagerModel   the view manager model
     * @return an instance of {@link ViewLoginPageController}
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
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel   the view manager model
     * @param signupViewModel    the signup view model
     * @return an instance of {@link ViewSignupPageController}
     */
    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);

    }

    /**
     * Creates an instance of {@link ViewProfileController}.
     *
     * @param viewManagerModel   the view manager model
     * @param profileViewModel   the profile view model
     * @return an instance of {@link ViewProfileController}
     * @throws IOException if an I/O error occurs
     */
    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);

    }
}
