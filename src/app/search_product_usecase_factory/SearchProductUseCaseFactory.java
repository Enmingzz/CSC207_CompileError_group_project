package app.search_product_usecase_factory;

import app.schedule_usecase_factory.SellerScheduleUseCaseFactory;
import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByTagDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByTagDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
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
import interface_adapter.schedule.GetBuyerSchedulePagePresenter;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import interface_adapter.view_product.*;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
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
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.search_product.SearchProductView;
import view.view_product.NonloggedInProductView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Factory class to create various controllers and view models for the Search Product use case.
 */
public class SearchProductUseCaseFactory {

    /**
     * Creates and returns a SearchProductView with the specified view models and controllers.
     *
     * @param searchProductViewModel the view model for search product
     * @param viewManagerModel the view manager model
     * @param buyerViewProductViewModel the view model for buyer view product
     * @param sellerViewProductViewModel the view model for seller view product
     * @param unloggedInViewModel the view model for unlogged-in view
     * @param signupViewModel the view model for signup
     * @param loginViewModel the view model for login
     * @param shoppingCartViewModel the view model for shopping cart
     * @param mainPageViewModel the view model for main page
     * @param viewProfileViewModel the view model for view profile
     * @return the created SearchProductView
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public static SearchProductView create(SearchProductViewModel searchProductViewModel,
                                           ViewManagerModel viewManagerModel,
                                           BuyerViewProductViewModel buyerViewProductViewModel,
                                           SellerViewProductViewModel sellerViewProductViewModel,
                                           UnloggedInViewModel unloggedInViewModel,
                                           SignupViewModel signupViewModel,
                                           LoginViewModel loginViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           MainPageViewModel mainPageViewModel,
                                           ViewProfileViewModel viewProfileViewModel) throws SQLException, IOException {
        SearchProductByNameController searchProductByNameController =
                SearchProductUseCaseFactory.createSearchProductByNameController(viewManagerModel, searchProductViewModel);
        SearchProductByTagController searchProductByTagController =
                SearchProductUseCaseFactory.createSearchProductByTagController(viewManagerModel, searchProductViewModel);
        ViewProductController viewProductController =
                SearchProductUseCaseFactory.createViewProductController
                        (viewManagerModel, buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel);
        GetSearchPageController getSearchPageController =
                SearchProductUseCaseFactory.createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController =
                SearchProductUseCaseFactory.creatViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController =
                SearchProductUseCaseFactory.createViewLoginPageController(loginViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController =
                SearchProductUseCaseFactory.createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        LogOutController logOutController =
                SearchProductUseCaseFactory.createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController =
                SearchProductUseCaseFactory.createProfileController(viewManagerModel, viewProfileViewModel);
        MainPageController mainPageController =
                SearchProductUseCaseFactory.createMainPageController(mainPageViewModel, viewManagerModel);
        return new SearchProductView(searchProductByNameController, searchProductByTagController,
                viewProductController, searchProductViewModel,getSearchPageController, viewSignupPageController,
                viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
    }

    /**
     * Creates an instance of {@link SearchProductByNameController}.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the view model for search product
     * @return an instance of {@link SearchProductByNameController}
     * @throws SQLException if a database access error occurs
     */
    private static SearchProductByNameController createSearchProductByNameController
            (ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        SearchProductByNameOutputBoundary searchProductByNamePresenter =
                new SearchProductByNamePresenter(viewManagerModel, searchProductViewModel);
        DatabaseProductReadByNameDataAccessObjectFactoryInterface databaseProductReadByNameDataAccessObjectFactory
                = new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByNameDataAccessInterface productReadByNameDataAccessObject =
                databaseProductReadByNameDataAccessObjectFactory.create(productFactory, scheduleFactory);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface =
                new DatabaseProductReadAllDataAccessObjectFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        SearchProductByNameInputBoundary searchProductByNameInteractor =
                new SearchProductByNameInteractor(productReadAllDataAccessObeject, productReadByNameDataAccessObject,
                        searchProductByNamePresenter);
        return new SearchProductByNameController(searchProductByNameInteractor);
    }

    /**
     * Creates an instance of {@link SearchProductByTagController}.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the view model for search product
     * @return an instance of {@link SearchProductByTagController}
     * @throws SQLException if a database access error occurs
     */
    private static SearchProductByTagController createSearchProductByTagController
            (ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        SearchProductByTagOutputBoundary searchProductByTagPresenter =
                new SearchProductByTagPresenter(searchProductViewModel, viewManagerModel);
        DatabaseProductReadByTagDataAccessObjectFactoryInterface databaseProductReadByTagDataAccessObjectFactory =
                new DatabaseProductReadByTagDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByTagDataAccessInterface productReadByTagDataAccessObject =
                databaseProductReadByTagDataAccessObjectFactory.create(productFactory, scheduleFactory);
        SearchProductByTagInputBoundary searchProductByTagInteractor =
                new SearchProductByTagInteractor(productReadByTagDataAccessObject, searchProductByTagPresenter);
        return new SearchProductByTagController(searchProductByTagInteractor);
    }

    /**
     * Creates an instance of {@link ViewProductController}.
     *
     * @param viewManagerModel the view manager model
     * @param buyerViewProductViewModel the view model for buyer view product
     * @param sellerViewProductViewModel the view model for seller view product
     * @param unloggedInViewModel the view model for unlogged-in view
     * @return an instance of {@link ViewProductController}
     * @throws SQLException if a database access error occurs
     */
    private static ViewProductController createViewProductController
            (ViewManagerModel viewManagerModel, BuyerViewProductViewModel buyerViewProductViewModel,
             SellerViewProductViewModel sellerViewProductViewModel, UnloggedInViewModel unloggedInViewModel) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        unloggedInViewModel, viewManagerModel);
        DatabaseQuestionReadDataAccessObjectFactoryInterface databaseQuestionReadDataAccessObjectFactory =
                new DatabaseQuestionReadDataAccessObjectFactory();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        AnswerFactory answerFactory = new CommonAnswerFactory();
        QuestionReadDataAccessInterface questionReadDataAccessObject =
                databaseQuestionReadDataAccessObjectFactory.create(questionFactory, answerFactory);
        ViewProductInputBoundary viewProductInteractor =
                new ViewProductInteractor(viewProductPresenter, questionReadDataAccessObject);
        return new ViewProductController(viewProductInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the view model for search product
     * @return an instance of {@link GetSearchPageController}
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
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel the view model for signup
     * @return an instance of {@link ViewSignupPageController}
     */
    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
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
     * @param mainPageViewModel the view model for main page
     * @param viewManagerModel the view manager model
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
     * Creates an instance of {@link SignupController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel the view model for signup
     * @param loginViewModel the view model for login
     * @return an instance of {@link SignupController}
     * @throws IOException if an I/O error occurs
     * @throws SQLException if a database access error occurs
     */
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

        DatabaseShoppingCartCreateDataAccessObjectFactoryInterface databaseShoppingCartCreateDataAccessObjectFactory =
                new DatabaseShoppingCartCreateDataAccessObjectFactory();
        ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject =
                databaseShoppingCartCreateDataAccessObjectFactory.create();

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory, shoppingCartCreateDataAccessObject
        );

        return new SignupController(userSignupInteractor);
    }

    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel the view model for login
     * @param viewManagerModel the view manager model
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
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel the view manager model
     * @param mainPageViewModel the view model for main page
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
     * Creates an instance of {@link ViewProfileController}.
     *
     * @param viewManagerModel the view manager model
     * @param profileViewModel the view model for view profile
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
