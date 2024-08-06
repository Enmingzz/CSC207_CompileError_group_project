package app.product_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByUserDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.objects.question.DatabaseQuestionCreateDataAccessObject;
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
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.*;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.search_product.view_search_page.GetSearchPagePresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.signup.view_signup_page.ViewSignupPagePresenter;
import interface_adapter.view_product.add_to_cart.AddToCartController;
import interface_adapter.view_product.add_to_cart.AddToCartPresenter;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import interface_adapter.view_product.publish_question.PublishQuestionController;
import interface_adapter.view_product.publish_question.PublishQuestionPresenter;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.view_profile.*;
import use_case.search_product.*;
import use_case.shopping_cart.*;
import use_case.signup.*;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInteractor;
import use_case.view_product.PublishQuestionOutputBoundary;
import view.view_product.BuyerViewProductView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Factory class for creating instances related to the BuyerViewProduct use case.
 */
public class BuyerViewProductUseCaseFactory {

    /**
     * Creates an instance of {@link BuyerViewProductView}.
     *
     * @param viewManagerModel the view manager model
     * @param mainPageViewModel the main page view model
     * @param shoppingCartViewModel the shopping cart view model
     * @param profileViewModel the profile view model
     * @param buyerViewProductViewModel the buyer view product view model
     * @param searchProductViewModel the search product view model
     * @param signupViewModel the signup view model
     * @param loginViewModel the login view model
     * @param viewUserProfileViewModel the view user profile view model
     * @return an instance of {@link BuyerViewProductView}
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    public static BuyerViewProductView create(ViewManagerModel viewManagerModel,
                                              MainPageViewModel mainPageViewModel,
                                              ShoppingCartViewModel shoppingCartViewModel,
                                              ViewProfileViewModel profileViewModel,
                                              BuyerViewProductViewModel buyerViewProductViewModel,
                                              SearchProductViewModel searchProductViewModel,
                                              SignupViewModel signupViewModel,
                                              LoginViewModel loginViewModel,
                                              ViewUserProfileViewModel viewUserProfileViewModel) throws SQLException, IOException {
        MainPageController mainPageController = createMainPageController(mainPageViewModel, viewManagerModel);
        AddToCartController addToCartController = createAddToCartController(viewManagerModel, shoppingCartViewModel, buyerViewProductViewModel);
        PublishQuestionController publishQuestionController = createPublishQuestionController(buyerViewProductViewModel, viewManagerModel);
        GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController = createViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController = createViewLoginPageController(loginViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController = createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController = createProfileController(viewManagerModel, profileViewModel);
        ViewUserProfileController viewUserProfileController = createUserProfileController(viewManagerModel, viewUserProfileViewModel);

        return new BuyerViewProductView(
                buyerViewProductViewModel,
                addToCartController,
                publishQuestionController,
                mainPageController,
                getSearchPageController,
                viewSignupPageController,
                viewLoginPageController,
                shoppingCartController,
                logOutController,
                viewProfileController,
                viewUserProfileController
        );
    }

    /**
     * Creates an instance of {@link ViewUserProfileController}.
     *
     * @param viewManagerModel the view manager model
     * @param viewUserProfileViewModel the view user profile view model
     * @return an instance of {@link ViewUserProfileController}
     * @throws SQLException if a database access error occurs
     */
    private static ViewUserProfileController createUserProfileController(ViewManagerModel viewManagerModel, ViewUserProfileViewModel viewUserProfileViewModel) throws SQLException {
        ViewUserProfileOutputBoundary viewUserProfilePresenter = new ViewUserProfilePresenter(viewUserProfileViewModel, viewManagerModel);
        DatabaseUserReadDataAccessObjectFactoryInterface userReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserFactory userFactory = new CommonUserFactory();
        UserReadDataAccessInterface userReadDataAccessObject = userReadDataAccessObjectFactory.create(userFactory);
        DatabaseProductReadByUserDataAccessObjectFactoryInterface databaseProductReadByUserDataAccessObjectFactoryInterface = new DatabaseProductReadByUserDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByUserDataAccessInterface productReadByUserDataAccessObject = databaseProductReadByUserDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ViewUserProfileInputBoundary viewUserProfileInteractor = new ViewUserProfileInteractor(viewUserProfilePresenter, userReadDataAccessObject, productReadByUserDataAccessObject);
        return new ViewUserProfileController(viewUserProfileInteractor);
    }

    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel the login view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link ViewLoginPageController}
     */
    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        ViewLoginPageOutputBoundary presenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary interactor = new ViewLoginPageInteractor(presenter);
        return new ViewLoginPageController(interactor);
    }

    /**
     * Creates an instance of {@link PublishQuestionController}.
     *
     * @param buyerViewProductViewModel the buyer view product view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link PublishQuestionController}
     * @throws SQLException if a database access error occurs
     */
    private static PublishQuestionController createPublishQuestionController(BuyerViewProductViewModel buyerViewProductViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        QuestionCreateDataAccessInterface questionCreateDataAccessObject = new DatabaseQuestionCreateDataAccessObject();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        PublishQuestionOutputBoundary presenter = new PublishQuestionPresenter(buyerViewProductViewModel, viewManagerModel);
        PublishQuestionInputBoundary publishQuestionInteractor = new PublishQuestionInteractor(questionCreateDataAccessObject, questionFactory, presenter);
        return new PublishQuestionController(publishQuestionInteractor);
    }

    /**
     * Creates an instance of {@link AddToCartController}.
     *
     * @param viewManagerModel the view manager model
     * @param shoppingCartViewModel the shopping cart view model
     * @param buyerViewProductViewModel the buyer view product view model
     * @return an instance of {@link AddToCartController}
     * @throws SQLException if a database access error occurs
     */
    private static AddToCartController createAddToCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel, BuyerViewProductViewModel buyerViewProductViewModel) throws SQLException {
        AddShoppingCartProductOutputBoundary addShoppingCartProductOutputPresenter = new AddToCartPresenter(viewManagerModel, shoppingCartViewModel, buyerViewProductViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface shoppingCartReadDataAccessObjectFactoryInterface = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObjectFactoryInterface.create(shoppingCartFactory, productFactory, scheduleFactory);
        DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface shoppingCartUpdateAddDataAccessObjectFactory = new DatabaseShoppingCartUpdateAddDataAccessObjectFactory();
        ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateDeleteDataAccessObject = shoppingCartUpdateAddDataAccessObjectFactory.create();
        AddShoppingCartProductInputBoundary addShoppingCartProductInteractor = new AddShoppingCartProductInteractor(shoppingCartUpdateDeleteDataAccessObject, addShoppingCartProductOutputPresenter, shoppingCartReadDataAccessObject);
        return new AddToCartController(addShoppingCartProductInteractor);
    }

    /**
     * Creates an instance of {@link ShoppingCartController}.
     *
     * @param viewManagerModel the view manager model
     * @param shoppingCartViewModel the shopping cart view model
     * @return an instance of {@link ShoppingCartController}
     * @throws SQLException if a database access error occurs
     */
    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShowShoppingCartOutputBoundary presenter = new ShoppingCartPresenter(viewManagerModel, shoppingCartViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess = databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory, productFactory, scheduleFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor = new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    /**
     * Creates an instance of {@link MainPageController}.
     *
     * @param mainPageViewModel the main page view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link MainPageController}
     * @throws SQLException if a database access error occurs
     */
    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObject = dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ShowMainPageInputBoundary showMainPageInteractor = new ShowMainPageInteractor(showMainPagePresenter, productReadAllDataAccessObject);
        return new MainPageController(showMainPageInteractor);
    }

    /**
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel the view manager model
     * @param mainPageViewModel the main page view model
     * @return an instance of {@link LogOutController}
     * @throws SQLException if a database access error occurs
     */
    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel, MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary logOutPresenter = new LogOutPresenter(mainPageViewModel, viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(logOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    /**
     * Creates an instance of {@link ViewProfileController}.
     *
     * @param viewManagerModel the view manager model
     * @param profileViewModel the profile view model
     * @return an instance of {@link ViewProfileController}
     * @throws IOException if an I/O error occurs
     */
    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel, ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel, viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link GetSearchPageController}
     * @throws SQLException if a database access error occurs
     */
    private static GetSearchPageController createGetSearchPageController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        GetSearchViewOutputBoundary getSearchViewPresenter = new GetSearchPagePresenter(searchProductViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObject = dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        GetSearchViewInputBoundary getSearchViewInteractor = new GetSearchViewInteractor(getSearchViewPresenter, productReadAllDataAccessObject);
        return new GetSearchPageController(getSearchViewInteractor);
    }

    /**
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel the signup view model
     * @return an instance of {@link ViewSignupPageController}
     * @throws SQLException if a database access error occurs
     */
    private static ViewSignupPageController createViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) throws SQLException {
        ViewSignupPageOutputBoundary presenter = new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary interactor = new ViewSignupPageInteractor(presenter);
        return new ViewSignupPageController(interactor);
    }

}
